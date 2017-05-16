function login() {
	debugger;
	var url = path+"user/getLogin.do";
	$.ajax({
		//提交数据的类型 POST GET
        type:"POST",
        //提交的网址
		url : url,
		//提交的数据
//		data : data,
		//格式
		contentType: "application/json; charset=utf-8",  
		//返回数据的格式
		datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
		//成功返回之后调用的函数
		success : function(data) {
			data;
			debugger;
		},
		// 调用执行后调用的函数
		/*complete : function(XMLHttpRequest, textStatus) {
			alert(XMLHttpRequest.responseText);
			alert(textStatus);
		},*/
		// 调用出错执行的函数
		error : function() {
			// 请求出错处理
		}
	});
}
