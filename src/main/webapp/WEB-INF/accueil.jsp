<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script src="ressources/accueil.js"></script>
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre SAW - Accueil</title>
</head>
<body onLoad = "loadData()">
	<div class="header">
		<h1>Théâtre Oxen</h1>
	</div>

<ul id = "menuClient">
  <li><a href="#home_client">Spectacles</a></li>
  <li><a href="#reps_client">Représentations</a></li>
  <li><a href="#" onClick="disconnect()">Déconnexion</a></li>
</ul>

<form method="post" action="home" id = "clientForm">
<input type="hidden" id="userType" name ="userType" value='${user}'/>
<input type="hidden" id="toDo" name="toDo" />
<input type="hidden" id="showsList" name="showsList" />
</form>	
			
<div class="container" style="background-color: #f1f1f1" id="showsClient">
<h2>Liste des spectacles</h2>
	<table id = "spectaclesTableClient">
		<th>
			Nom du spectacle
		</th>
	</table>
</div>

<div class="container" style="background-color: #f1f1f1" id="repsClient">
<h2>Liste des Représentations</h2>
	<table id = "repsTableClient">
		<th>
			Nom spectacle
		</th>
		<th>
			Date représentation
		</th>
		<th>
			Durée représentation
		</th>
		<th>
			Réserver
		</th>
		<th>
			Acheter
		</th>
	</table>
</div>
</body>
</html>