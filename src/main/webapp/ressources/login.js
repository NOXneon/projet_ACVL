// sets the username and password of the admin and resp prog
function loadData() {
	if (window.localStorage) {
		var adminLogin = localStorage.getItem('adminLogin');
		var respLogin = localStorage.getItem('respLogin');
		var users = localStorage.getItem('users');
		var adminTable = {'login' : 'admin', 'mdp' : 'root'};
		var respTable = {'login' : 'respo', 'mdp' : 'THEresponsable'}
		if (adminLogin == null) {
			localStorage.setItem('adminLogin', JSON.stringify(adminTable));
		}
		if (respLogin == null) {
			localStorage.setItem('respLogin', JSON.stringify(respTable));
		}
		if (users == null) {
			var usersTable = [];
			localStorage.setItem('users', JSON.stringify(usersTable));
		}
	} else {
		alert("db not working");
	}
	
}

// function that checks if user exists in db

function login() {
	var allow;
	if (document.querySelector('input[type="radio"]:checked') == null) {
		alert("Choisir mode de connexion");
	} else if (document.getElementById('uname').value == "" 
		|| document.getElementById('psw').value == "") {
		alert("Saisir nom d'utilisateur et mot de passe");
	} else {
		var radiobtn = document.querySelector('input[type="radio"]:checked').value;
		allow = false;
		if (radiobtn == "utilisateur") {
			var users = JSON.parse(localStorage.getItem('users'));
			if (users != null) {
				for (var user in users) {
					var tmp = users[user];
					if (tmp.login == document.getElementById('uname').value
							&& tmp.mdp == document.getElementById('psw').value) {
						//Allow login because user is found in db
						allow = true;
					}
				}
			}
		}
		else if (radiobtn == "respProg") {
			console.log('respo');
			if (document.getElementById('uname').value == "respo" 
				&& document.getElementById('psw').value == "THEresponsable") {
				allow = true;
			}
		} else if(radiobtn == "admin") {
			console.log('admin');
			if (document.getElementById('uname').value == "admin" 
				&& document.getElementById('psw').value == "root") {
				allow = true;
			}
		} else {
			alert("Se connecter en tant que?");
		}
		allowLogin(allow);
	}
}

// function that allows login or not
function allowLogin(isAllowed) {
	if (isAllowed) {
		// who is trying to log in
		var who = document.querySelector('input[type="radio"]:checked').value;
		if (who == "utilisateur") {
			window.location="/Theater/accueil?user="+who;
		} else {
			window.location="/Theater/home?user="+who;
		}
	} else {
		alert("Mauvais nom d'utilisateur/Mot de passe");
	}
}

function Inscription() {
	window.location="/Theater/register";
}