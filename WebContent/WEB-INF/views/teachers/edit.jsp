<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Преподаватель</title>
<style>
	form fieldset {
		width : 40%;
	} 
	form fieldset label {
		display : block;
		/*width : 50%;
		float :left;*/
	}
	form fieldset input, form fieldset textarea {
		width : 100%;
	}
</style>
</head>
<body>
	<h1>Преподаватель</h1>
	<form method="POST">
		<fieldset>
			<div>
				<label for="name">Имя: </label>
				<input id="name" type="text" name="name" value="${teacher.name}">
			</div>
			<div>
				<label for="addr">Адрес: </label>
				<input  id="addr" type="number" name="length" value="${teacher.addr}">
			</div>
			<div>
				<label for="phone">Телефон: </label>
				<textarea id="phone" name="description" rows="7">${teacher.phone}</textarea>
			</div>
			<div>
				<input type="submit" value="Сохранить">
			</div>
		</fieldset>
	
	</form>

</body>
</html>