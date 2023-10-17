<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="ressources/login.js"></script>
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre Oxen - Connexion</title>
</head>
<body onLoad="loadData()">
	<div class="header">
		<h1>Théâtre Oxen</h1>
	</div>
	<h2>Connexion</h2>

	<div class = "form">

		<div class="container">
			<label><b>Nom d'utilisateur</b></label>
			<input type="text" id="uname" required>
			<label ><b>Mot de passe</b></label>
			<input type="password" id="psw" required>

			<button onClick="login()">Se connecter en tant que</button>
			<div>
				<label> <input type="radio" name="user" value = "utilisateur" checked> Utilisateur</label>
				<label> <input type="radio" name="user" value = "respProg"> Resp. Prog.</label> 
				<label> <input type="radio" name="user" value = "admin"> Admin</label>
			</div>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn" onClick="Inscription()">Inscription</button>
		</div>
	</div>
</body>
</html>