(function($) {

	/**
	 * 将表单序列化json对象
	 */
	$.fn.serializeObject = function() {
		var obj = {};
		var count = 0;
		$.each(this.serializeArray(), function(i, o) {
			var n = o.name, v = o.value;
			count++;
			obj[n] = obj[n] === undefined ? v : $.isArray(obj[n]) ? obj[n]
					.concat(v) : [ obj[n], v ];
		});
		// obj.nameCounts = count + "";//表单name个数
		return JSON.stringify(obj);
	};

	/**
	 * 将表单序列化json对象
	 * 
	 * 适用于有多个值的输入控件，例如复选框、多选的select
	 */
	$.fn.serializeJson = function() {
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							serializeObj[this.name].push(this.value);
						} else {
							serializeObj[this.name] = [
									serializeObj[this.name], this.value ];
						}
					} else {
						serializeObj[this.name] = this.value;
					}
				});
		return serializeObj;
	};

	$("#navbar-nav").find("li").unbind();

	$("#navbar-nav").find("li").on("click", function() {
		$("#navbar-nav").find("li").removeClass("active");
		$(this).addClass("active");
	});
})(jQuery);