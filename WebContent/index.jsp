<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cmn-Hans">
<head>
	<meta charset="UTF-8">
	<title>电码转换</title>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
</head>
	<body>
		<div>
			<textarea id="translate_input" autofocus="autofocus"></textarea>
		</div>
		<div>
			<button id="toCode">转换为电码</button>
			<button id="toText">转换为文本</button>
		</div>
		<div>
			<label id="translate_output"></label>
		</div>
	</body>
	<script>
		$(function(){
			$("#toCode").click(function(){
				$("translate_output").load("toCode",$("#translate_input").val());
			});
			$("#toText").click(function(){
				$("translate_output").load("toText",$("#translate_input").val());
			});
		});
	</script>
</html>