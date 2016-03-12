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
