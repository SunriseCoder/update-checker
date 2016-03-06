package app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.dao.DatabaseOperations;

@RestController
@RequestMapping("/rest/database/")
public class DatabaseRestController {
	@Autowired
	private DatabaseOperations databaseOperations;

	@RequestMapping("/table-list")
	public Object tableList() throws Exception {
		Object data = databaseOperations.getTableList();
		return data;
	}

	@RequestMapping("/table-data/{tableName}")
	public Object tableData(@PathVariable("tableName") String tableName) throws Exception {
		Object data = databaseOperations.getTableData(tableName);
		return data;
	}

	@RequestMapping("/delete-row")
	public void deleteRow(@RequestParam("tableName") String tableName,
			@RequestParam("id") Long id) throws Exception {

		databaseOperations.deleteRow(tableName, id);
	}

	@RequestMapping("/clear-table")
	public void clearTable(@RequestParam("tableName") String tableName) throws Exception {
		databaseOperations.clearTable(tableName);
	}
}
