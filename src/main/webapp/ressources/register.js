function connexion() {
	window.location="/Theater";
}



function loadData() {
	//passer liste des clients au controleur
	document.getElementById("clientsList").value = localStorage.getItem('users');
	//eventually adding client
	if (document.getElementById("addingClient").value == "The client already exists") {
		alert("Le compte existe déjà");
	} else if (document.getElementById("addingClient").value == "The client can be added"){
		var users = JSON.parse(localStorage.getItem('users'));
		users.push(JSON.parse(document.getElementById("clientToAdd").value));
		document.getElementById("clientToAdd").value = "";
		alert("Nouvel utilisateur créé");
		localStorage.setItem('users', JSON.stringify(users));
		connexion();
	}
}
function signUp() {
	
	var name = document.getElementById('nom').value;
	var surname = document.getElementById('prenom').value;
	var username = document.getElementById('login').value;
	var password = document.getElementById('mdp').value;
	var mail = document.getElementById('mail').value;
	var phone = document.getElementById('tel').value;
	
	if (!checkMail(mail)) {
		alert("Adresse mail non conforme");
	} else if (!checkPhone(phone)) {
		alert("Numéro de téléphone non conforme");
	} else if (password == "") {
		alert("Saisir un mot de passe");
	} else {
		document.getElementById("registerForm").submit();
	}
}

function checkMail(user_mail) {
	 return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(user_mail);
}

function checkPhone(user_phone) {
	return !isNaN(user_phone)
	&& user_phone.length == 10 
		&& user_phone.charAt(0) == '0';
}