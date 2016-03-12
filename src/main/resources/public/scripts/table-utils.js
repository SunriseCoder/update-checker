var Table = {
	parseColumns: function(columnsString) {
    	columnsString = columnsString.replace(/ /g, '');
    	var columns = columnsString.split(',');
    	return columns;
    }
}
