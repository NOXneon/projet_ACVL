
function loadData() {
	if (window.localStorage) {
		var spectacles = localStorage.getItem('spectacles');
		var spectaclesTable = [];
		if (spectacles == null) {
			localStorage.setItem('spectacles', JSON.stringify(spectaclesTable));
		}
	} else {
		alert("db not working");
	}
	//passer liste des spectacles au controleur
	document.getElementById("showsList").value = localStorage.getItem('spectacles');
	//eventually adding show
	if (document.getElementById("addingShow").value == "The show already exists") {
		alert("Le spectacle existe déjà");
		window.location="/Theater/home?user="+document.getElementById("userType").value;
	} else if (document.getElementById("addingShow").value == "The show can be added"){
		var spectacles = JSON.parse(localStorage.getItem('spectacles'));
		document.getElementById("addingShow").value = "";
		spectacles.push(JSON.parse(document.getElementById("showToAddPostMessage").value));
		localStorage.setItem('spectacles', JSON.stringify(spectacles));
		window.location="/Theater/home?user="+document.getElementById("userType").value;
	}
	
	//eventually adding rep
	if (document.getElementById("addingRep").value == "The rep does not fit") {
		alert("La représentation chevauche une autre/Le spectacle n'existe pas");
		window.location="/Theater/home?user="+document.getElementById("userType").value;
	} else if (document.getElementById("addingRep").value == "The rep can be added"){
		var spectacles = JSON.parse(localStorage.getItem('spectacles'));
		document.getElementById("addingRep").value = "";
		var representation = document.getElementById("repToAddPostMessage").value;
		var repShow = document.getElementById("repShow").value;
		for (var i in spectacles) {
			if (spectacles[i].nom == repShow) {
				spectacles[i].representations.push(JSON.parse(representation));
			}
		}
		localStorage.setItem('spectacles', JSON.stringify(spectacles));
		window.location="/Theater/home?user="+document.getElementById("userType").value;
	}
	
	var containers = document.querySelectorAll("div[class=container]");
	var uls = document.querySelectorAll("ul");
	for (var i = 0; i < uls.length; i++) {
		uls[i].style.display = "none";
	}
	for (var i = 0; i < containers.length; i++) {
		containers[i].style.display = "none";
	}
	var params = new URLSearchParams(location.search);
	if (params.get('user') == "admin") {
		loadDataAdmin();
	} else if (params.get('user') == 'respProg'){
		loadDataRespo();
	}
}
function disconnect() {
	window.location="/Theater";
}

function loadDataAdmin() {
	document.getElementById("menuAdmin").style.display="block";
	document.getElementById("showsAdmin").style.display="block";
	document.getElementById("clientsAdmin").style.display="block";
	document.getElementById("repsAdmin").style.display="block";
	
	document.getElementById("saveShowspectaclesTableAdmin").disabled = true;
	
	displayShows("spectaclesTableAdmin");
	displayClients("clientsTableAdmin");
	displayReps("repsTableAdmin");
}

function loadDataRespo() {
	document.getElementById("menuRespo").style.display="block";
	document.getElementById("showsRespo").style.display="block";
	document.getElementById("clientsRespo").style.display="block";
	document.getElementById("repsRespo").style.display="block";
	
	document.getElementById("saveShowspectaclesTableRespo").disabled = true;
	document.getElementById("saveRepspectaclesTableRespo").disabled = true;
	
	displayShows("spectaclesTableRespo");
	displayClients("clientsTableRespo");
	displayReps("repsTableRespo");
}
// function to add a show
function addShow(idTable) {
	var table = document.getElementById(idTable);
	table.style.display = "block";
	var row = table.insertRow(-1);
	var del = row.insertCell(-1);
	del.innerHTML = '<input type = "checkbox">';
	var name = row.insertCell(-1);
	name.innerHTML = '<input type = "text" id = "showName'+row.indexRow+'">';
	document.getElementById("saveShow"+idTable).disabled = false;
}

//function to add a rep
function addRep(idTable) {
	document.getElementById("saveRepspectaclesTableRespo").disabled = false;
	var table = document.getElementById(idTable);
	table.style.display = "block";
	var row = table.insertRow(-1);
	var del = row.insertCell(-1);
	del.innerHTML = '<input type = "checkbox">';
	var showName = row.insertCell(-1);
	showName.innerHTML = '<input type = "text" id = "showName'+row.indexRow+'">';
	var repDate = row.insertCell(-1);
	repDate.innerHTML = '<input type = "text" id = "repDate'+row.indexRow+'">';
	var repDuration = row.insertCell(-1);
	repDuration.innerHTML = '<input type = "text" id = "repDuration'+row.indexRow+'">';
}

//function to save a rep
function saveRep(idTable) {
	document.getElementById("toDo").value = "addRep";
	var repToAdd;
	var params = new URLSearchParams(location.search);
	document.getElementById("userType").value = params.get('user');
	var table = document.getElementById(idTable);
	if (table.rows[table.rows.length-1].cells[1].firstChild.value != undefined
			&& table.rows[table.rows.length-1].cells[2].firstChild.value != undefined
			&& table.rows[table.rows.length-1].cells[3].firstChild.value != undefined
			&& !isNaN(table.rows[table.rows.length-1].cells[3].firstChild.value)) {
		repToAdd = {"date" : table.rows[table.rows.length-1].cells[2].firstChild.value,
			"duree" : table.rows[table.rows.length-1].cells[3].firstChild.value};
		document.getElementById("repShow").value = table.rows[table.rows.length-1].cells[1].firstChild.value;
		document.getElementById("repToAdd").value = JSON.stringify(repToAdd);
		//send the list of shows to add
		document.getElementById("showForm").submit();
	} else {
		alert("Erreur dans les données saisies");
	}
	
}

//function to save a show
function saveShow(idTable) {
	document.getElementById("toDo").value = "addShow";
	var showToAdd;
	var params = new URLSearchParams(location.search);
	document.getElementById("userType").value = params.get('user');
	var table = document.getElementById(idTable);
	if (table.rows[table.rows.length-1].cells[1].firstChild.value != undefined) {
		showToAdd = {
			"nom":table.rows[table.rows.length-1].cells[1].firstChild.value,
			"representations":[]
			};
		//send the list of shows to add
		document.getElementById("showsToAdd").value = JSON.stringify(showToAdd);
		document.getElementById("showForm").submit();
	}else {
		alert("Erreur dans les données saisies");
	}
	
}

function displayShows(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	table.style.display="block";
	if (table.rows.length == 0) {
		table.style.display = "none";
	}
	for (var i = 0; i < spectacles.length; i++) {
		var row = table.insertRow(-1);
		if (table.rows[0].cells.length == 2) {
			var del = row.insertCell(-1);
			del.innerHTML = '<input type = "checkbox">';
		}
		var name = row.insertCell(-1);
		name.innerHTML = spectacles[i].nom;
	}
}

function displayReps(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	table.style.display="block";
	if (table.rows.length == 0) {
		table.style.display = "none";
	}
	for (var i = 0; i < spectacles.length; i++) {
		var reps = spectacles[i].representations;
		for (var j = 0; j < reps.length; j++) {
			var row = table.insertRow(-1);
			if (table.rows[0].cells.length == 4) {
				var del = row.insertCell(-1);
				del.innerHTML = '<input type = "checkbox">';
			}
			var showName = row.insertCell(-1);
			showName.innerHTML = spectacles[i].nom;
			var repDate = row.insertCell(-1);
			repDate.innerHTML = reps[j].date;
			var repDuration = row.insertCell(-1);
			repDuration.innerHTML = reps[j].duree;
		}
	}
}

function displayClients(idTable) {
	var users = JSON.parse(localStorage.getItem('users'));
	var table = document.getElementById(idTable);
	table.style.display = "block";
	if (table.rows.length == 0) {
		table.style.display = "none";
	}
	for (var i = 0; i < users.length; i++) {
		var user = users[i];
		var row = table.insertRow(-1);
		if (idTable == "clientsTableAdmin") {
			var del = row.insertCell(-1);
			del.innerHTML = '<input type = "checkbox">';
		} else {
			var del = row.insertCell(-1);
		}
		var name = row.insertCell(-1);
		name.innerHTML = user.nom;
		var surname = row.insertCell(-1);
		surname.innerHTML = user.prenom;
		var login = row.insertCell(-1);
		login.innerHTML = user.login;
		var mail = row.insertCell(-1);
		mail.innerHTML = user.mail;
		var tel = row.insertCell(-1);
		tel.innerHTML = user.tel;
	}
}

function delShow(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	for (var i = table.rows.length-1; i > 0; i--) {
		if (table.rows[i].cells[0].firstChild.checked) {
			delete spectacles[i-1];
		}
	}
	spectacles = spectacles.filter(el => el != null);
	localStorage.setItem('spectacles', JSON.stringify(spectacles));
	location.reload();
}

function delRep(idTable) {
	var spectacles = JSON.parse(localStorage.getItem('spectacles'));
	var table = document.getElementById(idTable);
	for (var i = table.rows.length-1; i > 0; i--) {
		if (table.rows[i].cells[0].firstChild.checked) {
			var spectacle = table.rows[i].cells[1].innerHTML;
			for (var j in spectacles) {
				if (spectacles[j].nom == spectacle) {
					var representationDate = table.rows[i].cells[2].innerHTML;
					var representations = spectacles[j].representations;
					for (var k in representations) {
						if (representations[k].date == representationDate) {
							delete representations[k];
							table.deleteRow(i);
						}
					}
					spectacles[j].representations = spectacles[j].representations.filter(el => el != null);
				}
			}
		}
		
	}
	spectacles = spectacles.filter(el => el != null);
	localStorage.setItem('spectacles', JSON.stringify(spectacles));
	location.reload();
}

function delClient(idTable) {
	var users = JSON.parse(localStorage.getItem('users'));
	var table = document.getElementById(idTable);
	for (var i = table.rows.length-1; i > 0; i--) {
		console.log(table.rows.length);
		if (table.rows[i].cells[0].firstChild.checked) {
			delete users[i-1];
		}
	}
	users = users.filter(el => el != null);
	localStorage.setItem('users', JSON.stringify(users));
	location.reload();
}
 