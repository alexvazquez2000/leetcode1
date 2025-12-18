package com.hackerrank.easy;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

public class fusionauthioSQL {

	public static void main(String[] args) throws SQLException {
		Connection conn = connectToDB();
		Statement stmt = null;

		try {
			//Create a Statement object
			stmt = conn.createStatement();

			// createDefsTable(stmt);
			// createTables(stmt);
			showData(stmt);
			runQueries(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. Close resources
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Reads the DB settings from property file and connects to DB
	 * @return a connection to the DB 
	 * @throws SQLException 
	 */
	private static Connection connectToDB() throws SQLException {
		String url = "";
		String user = "";
		String password = "";

		Properties prop = new Properties();
		try (InputStream input = Files.newInputStream(Paths.get("db_config.properties"))) {
			prop.load(input);
			url = prop.getProperty("database.url");
			user = prop.getProperty("database.user");
			password = prop.getProperty("database.password");
		} catch (Exception e) {
			System.out.println("Error loading properties file: " + e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		// Establish the connection to the database
		// The driver is automatically loaded in modern JDBC versions
		return DriverManager.getConnection(url, user, password);
	}

	private static void runQueries(Statement stmt) throws SQLException {
		System.out.println("With lookup where month is Jun 2025");
		//"SELECT filetype, WID, dwest FROM west, definitions where wid=id and month(dwest)='06' and year(dwest)='2025'"
		String sql = "SELECT filetype, WID, dwest FROM west, definitions where wid=id and dwest like '2025-06%'";
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String t = rs.getString("filetype");
				int wid = rs.getInt("WID");
				String dwest = rs.getString("dwest");
				System.out.println(wid + "\t" + t + ", " + dwest);
			}
		}
		System.out.println("-----------------");

		System.out.println("Counts with lookup where month is Jun 2025 - this is by file type - and only on WESTN");
		sql = "SELECT count(*) as c, filetype, dwest "
				+ "FROM west, definitions "
				+ "WHERE wid=id and dwest like '2025-06%'"
				+ "GROUP BY filetype";
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				String t = rs.getString("filetype");
				int c = rs.getInt("c");
				String dwest = rs.getString("dwest");
				System.out.println(c + "\t" + t + ", " + dwest);
			}
		}
		System.out.println("-----------------");

	}

	private static void showData(Statement stmt) throws SQLException {
		String sql = "SELECT * from definitions order by id";
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int id = rs.getInt("ID");
				String filetype = rs.getString("filetype");
				System.out.println("ID: " + id + ", filetype: " + filetype);
			}
		}
		System.out.println("-----------------");
		sql = "SELECT * from west order by dwest";
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int wid = rs.getInt("WID");
				String dwest = rs.getString("dwest");
				System.out.println("WID: " + wid + ", " + dwest);
			}
		}
		System.out.println("-----------------");
		sql = "SELECT * from east order by deast";
		try (ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				int eid = rs.getInt("EID");
				String deast = rs.getString("deast");
				System.out.println("EID: " + eid + ", " + deast);
			}
		}
		System.out.println("-----------------\n");
	}

	private static void createTables(Statement stmt) throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS west (" + "wid INT NOT NULL," + "dwest DATE)";
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE IF NOT EXISTS east (" + "eid INT NOT NULL," + "deast DATE)";
		stmt.executeUpdate(sql);
		System.out.println("Created tables");

		sql = "DELETE from west";
		stmt.executeUpdate(sql);

		sql = "DELETE from east";
		stmt.executeUpdate(sql);

		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			int fileType = r.nextInt(3) + 1;
			// timestamp is in YYYY-MM-DD, ie '2025-12-15'
			int m = (r.nextInt(12) + 1);
			//skip the end of the months - so it works for Feb and months with just 30 days - could have a table to get max days per month
			int d = (r.nextInt(27) + 1);
			String dDate = "2025-" + (m < 10 ? "0" : "") + m + "-" + (d < 10 ? "0" : "") + d;
			// System.out.println("date= '" + dDate + "'");

			int insertInto = r.nextInt(3);
			if (insertInto == 0 || insertInto == 2) {
				sql = "INSERT into west (wid, dwest) values (" + fileType + ",'" + dDate + "')";
				stmt.executeUpdate(sql);
			}
			if (insertInto == 1 || insertInto == 2) {
				sql = "INSERT into east (eid, deast) values (" + fileType + ",'" + dDate + "')";
				stmt.executeUpdate(sql);
			}
			System.out.println("inserted data for date " + dDate);
		}
	}

	private static void createDefsTable(Statement stmt) throws SQLException {
		String sql = "CREATE TABLE IF NOT EXISTS definitions (" + "id INT NOT NULL," + "filetype VARCHAR(255),"
				+ "PRIMARY KEY (id))";
		stmt.executeUpdate(sql);
		System.out.println("Created table 'Registrations' in the given database...");

		sql = "INSERT into definitions (id, filetype) values (1,'pdf'), (2, 'doc'), (3,'xls')";
		stmt.executeUpdate(sql);
		System.out.println("Inserted definitions");

	}
}
