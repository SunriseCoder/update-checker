var Strings = {
	arrayToCommaSeparated: function(array) {
		if (!array || array.length == 0) {
			return "";
		}

		var string = "";
		for (var i = 0; i < array.length; i++) {
        	var element = array[i];
        	string = string.concat(element).concat(', ');
        }

       	string = string.substring(0, string.length - 2);

       	return string;
	},
	
	arrayToLines: function(array) {
		if (!array || array.length == 0) {
			return "";
		}

		var value = "";
		array.forEach(function(element){
			value = value.concat(element).concat('\n');
		});

		value = value.substring(0, value.length - 1);

		return value;
	},

	hasArrayAString: function (array, string) {
		var found = false;
		array.forEach(function(element){
			if (element == string) {
				found = true;
			}
		});
		return found;
	}
}
