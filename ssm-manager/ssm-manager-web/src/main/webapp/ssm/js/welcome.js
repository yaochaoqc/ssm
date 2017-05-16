function del(id) {
	var url = path+"user/doPostDel.do";
//	var url = path+"user/doGetDel.do";
	var params = [
	              {"name":"userId","value":id}
	              ];
	$.ajax({
		//提交数据的类型 POST GET
        type:"POST",
//		type:"GET",
        //提交的网址
		url : url,
		//提交的数据
		data : params,
		async:true,
		//格式
		//默认为"application/x-www-form-urlencoded"。该默认值适合大多数应用场合。
		contentType: "application/x-www-form-urlencoded",
		//contentType: "application/json; charset=utf-8",
		//返回数据的格式
		datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
		//成功返回之后调用的函数
		success : function(data) {
			console.log(data);
			var fag = data.fag;
			var userId = data.userId;
			if (fag=="ok") {
				$("#"+userId).remove();
			}
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
