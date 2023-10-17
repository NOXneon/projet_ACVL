<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script src="ressources/home.js"></script>
<link rel="stylesheet" type="text/css" href="ressources/style.css">
<title>Théâtre Oxen - Accueil</title>
</head>
<body onLoad = "loadData()">
	<div class="header">
		<h1>Théâtre Oxen</h1>
	</div>
<ul id = "menuAdmin">
  <li><a href="#home_admin">Spectacles</a></li>
  <li><a href="#clients_admin">Liste clients</a></li>
  <li><a href="#reps_admin">Représentations</a></li>
  <li><a href="#" onClick="disconnect()">Déconnexion</a></li>
</ul>
<ul id = "menuRespo">
  <li><a href="#home_admin">Spectacles</a></li>
  <li><a  href="#clients_respo">Liste clients</a></li>
  <li><a href="#reps_admin">Représentations</a></li>
  <li><a href="#stats">Statistiques</a></li>
  <li><a href="#" onClick="disconnect()">Déconnexion</a></li>
</ul>

<form method="post" action="home" id = "showForm">
<input type="hidden" id="userType" name ="userType" value='${user}'/>
<input type="hidden" id="toDo" name="toDo" />
<input type="hidden" id="showsList" name="showsList" />
<input type="hidden" id="showsToAdd" name="showsToAdd" />
<input type="hidden" id="addingShow" value="${addingShowMessage}" />
<input type="hidden" id="showToAddPostMessage" value='${showToAddPostMessage}' />
<input type="hidden" id="repShow" name="repShow" value = '${repShow }'/>
<input type="hidden" id="repToAdd" name="repToAdd" />
<input type="hidden" id="addingRep" value="${addingRepMessage}" />
<input type="hidden" id="repToAddPostMessage" value='${repToAddPostMessage}' />
</form>		
			
<div class="container" style="background-color: #f1f1f1" id="showsAdmin">
<h2>Liste des spectacles</h2>
	<button type="button" class="cancelbtn" onClick="addShow('spectaclesTableAdmin')">Ajouter spectacle</button>
	<button type="button" class="cancelbtn" onClick="delShow('spectaclesTableAdmin')">Supprimer spectacle</button>
	<button type="button" class="cancelbtn" id = "saveShowspectaclesTableAdmin" onClick="saveShow('spectaclesTableAdmin')">Sauvegarder spectacle</button>
	<table id = "spectaclesTableAdmin">
		<th>
			
		</th>
		<th>
			Nom du spectacle
		</th>
	</table>
</div>

<div class="container" style="background-color: #f1f1f1" id="showsRespo">
<h2>Liste des spectacles</h2>
	<button type="button" class="cancelbtn" onClick="addShow('spectaclesTableRespo')">Ajouter spectacle</button>
	<button type="button" class="cancelbtn" onClick="delShow('spectaclesTableRespo')">Supprimer spectacle</button>
	<button type="button" class="cancelbtn" id = "saveShowspectaclesTableRespo" onClick="saveShow('spectaclesTableRespo')">Sauvegarder spectacle</button>
	<table id = "spectaclesTableRespo">
		<th>
			
		</th>
		<th>
			Nom du spectacle
		</th>
	</table>
</div>

<div class="container" style="background-color: #f1f1f1" id="clientsAdmin">
<h2>Liste des clients</h2>
<button type="button" class="cancelbtn" onClick="delClient('clientsTableAdmin')">Supprimer client</button>
	<table id = "clientsTableAdmin">
		<th>
			
		</th>
		<th>
			Nom client
		</th>
		<th>
			Prénom client
		</th>
		<th>
			Nom d'utilisateur client
		</th>
		<th>
			Adresse mail client
		</th>
		<th>
			Téléphone client
		</th>
	</table>
</div>

<div class="container" style="background-color: #f1f1f1" id="clientsRespo">
<h2>Liste des clients</h2>
	<table id = "clientsTableRespo">
		<th>
			
		</th>
		<th>
			Nom client
		</th>
		<th>
			Prénom client
		</th>
		<th>
			Nom d'utilisateur client
		</th>
		<th>
			Adresse mail client
		</th>
		<th>
			Téléphone client
		</th>
	</table>
</div>

<div class="container" style="background-color: #f1f1f1" id="repsAdmin">
<h2>Liste des Représentations</h2>
	<table id = "repsTableAdmin">
		<th>
			Nom spectacle
		</th>
		<th>
			Date représentation
		</th>
		<th>
			Durée représentation
		</th>
	</table>
</div>

<div class="container" style="background-color: #f1f1f1" id="repsRespo">
<h2>Liste des Représentations</h2>
	<button type="button" class="cancelbtn" onClick="addRep('repsTableRespo')">Ajouter représentation</button>
	<button type="button" class="cancelbtn" onClick="delRep('repsTableRespo')">Supprimer représentation</button>
	<button type="button" class="cancelbtn" id = "saveRepspectaclesTableRespo" onClick="saveRep('repsTableRespo')">Sauvegarder représentation</button>
	<table id = "repsTableRespo">
		<th>
			
		</th>
		<th>
			Nom spectacle
		</th>
		<th>
			Date représentation
		</th>
		<th>
			Durée représentation
		</th>
	</table>
</div>

</body>
</html>