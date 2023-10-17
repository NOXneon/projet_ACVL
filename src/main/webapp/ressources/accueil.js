
function loadData() {
		if (window.localStorage) {
		//init la liste des spectacles
		var spectacles = localStorage.getItem('spectacles');
		var spectaclesTable = [];
		if (spectacles == null) {
			localStorage.setItem('spectacles', JSON.stringify(spectaclesTable));
		}
	} else {
		alert("db not working");
	}
	//passer liste des spectacles au servlet
	document.getElementById("showsList").value = localStorage.getItem('spectacles');
	displayShows("spectaclesTableClient");
	displayReps("repsTableClient");
}

function disconnect() {
	window.location="/Theater";
}

//affiche la liste des spectacles
function displayShows(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	table.style.display="block";
	if (table.rows.length == 0) {
		table.style.display = "none";
	}
	for (var i = 0; i < spectacles.length; i++) {
		var row = table.insertRow(-1);
		var name = row.insertCell(-1);
		name.innerHTML = spectacles[i].nom;
	}
}
//afficher la liste des représentations
function displayReps(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	for (var i = 0; i < spectacles.length; i++) {
		//récupérer les représentations du spectacle
		var reps = spectacles[i].representations;
		for (var j = 0; j < reps.length; j++) {
			var row = table.insertRow(-1);
			var showName = row.insertCell(-1);
			showName.innerHTML = spectacles[i].nom;
			var repDate = row.insertCell(-1);
			repDate.innerHTML = reps[j].date;
			var repDuration = row.insertCell(-1);
			repDuration.innerHTML = reps[j].duree;
			var reserver = row.insertCell(-1);
			var spec = spectacles[i].nom;
			reserver.innerHTML = "<button type = 'button' onClick='Reserver(\""+spec+"\")'>Réserver</button>";
			var acheter = row.insertCell(-1);
			acheter.innerHTML = "<button type = 'button' onClick='Acheter(\""+spec+"\")'>Acheter</button>";
		}
	}
}

function Reserver(spectacle){
	window.location="/Theater/reserver?spectacle="+spectacle;
}

function Acheter(spectacle){
	window.location="/Theater/acheter?spectacle="+spectacle;
}
 