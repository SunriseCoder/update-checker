package app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseOperations {
	@Autowired
	DataSource dataSource;

	public Object getTableList() throws Exception {
		Connection c = dataSource.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SHOW TABLES");

		List<Map<String, String>> data = new ArrayList<>();
		while (rs.next()) {
			Map<String, String> row = new HashMap<>();
			row.put("TABLE_NAME", rs.getString("TABLE_NAME"));
			row.put("TABLE_SCHEMA", rs.getString("TABLE_SCHEMA"));
			data.add(row);
		}

		return data;
	}

	public Object getTableData(String tableName) throws Exception {
		Connection c = dataSource.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);

		// Columns
		ResultSetMetaData metaData = rs.getMetaData();
		int columnsNumber = metaData.getColumnCount();
		List<String> columns = new ArrayList<>();
		for (int i = 0; i < columnsNumber; i++) {
			String column = metaData.getColumnName(i + 1);
			columns.add(column);
		}

		// Data
		List<List<String>> data = new ArrayList<>();
		while (rs.next()) {
			List<String> row = new ArrayList<>();
			for (int i = 0; i < columnsNumber; i++) {
				String value = rs.getString(i + 1);
				row.add(value);
			}
			data.add(row);
		}

		Map<String, Object> result = new HashMap<>();
		result.put("columns", columns);
		result.put("data", data);
		return result;
	}

	public void deleteRow(String tableName, Long id) throws Exception {
		Connection c = dataSource.getConnection();
		Statement stmt = c.createStatement();
		stmt.execute("DELETE FROM " + tableName + " WHERE ID = " + id);
	}

	public void clearTable(String tableName) throws Exception {
		Connection c = dataSource.getConnection();
		Statement stmt = c.createStatement();
		stmt.execute("TRUNCATE TABLE " + tableName);
	}
}
