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

var Locales = {
	keys: undefined,

	load: function() {
		var xhrObject = new XMLHttpRequest();
        xhrObject.overrideMimeType("application/json");
        // synchrones AJAX deprecated, hier aber notwendig um sicherzustellen,
        // dass Texte da bevor Komponenten geladen werden
        xhrObject.open('GET', '/i18n/default.json', false);
        xhrObject.send();
        keys = JSON.parse(xhrObject.responseText);
	},

	i18n: function(key) {
		var value = keys[key];
		
		if (!value) {
			console.log('Cannot find i18n message for ' + key);
			return key;
		}
		
		return value;
	}
}
Locales.load();

var Url = {
	getParam: function(name) {
		var params = this._getAllParams();
		var param = params[name];
		return param;
	},

	_getAllParams: function() {
		var url = document.URL;
		var paramsStarts = url.indexOf('?')

		var params = {};

		if (paramsStarts != -1) {
			var paramsString = url.substr(paramsStarts + 1);
			params = this._parseParams(paramsString);
		}

		return params;
	},

	_parseParams: function(string) {
		var paramsStrings = string.split('&');
		var result = {};
		for (var i = 0; i < paramsStrings.length; i++) {
			var paramString = paramsStrings[i];
			var paramStrings = paramString.split('=');
			result[paramStrings[0]] = paramStrings[1];
		}
		return result;
	}
}
