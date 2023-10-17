package Controleur;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import Modele.Utilisateur.Client;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Récupérer la liste des clients de la BDD
		String users = request.getParameter("clientsList");
		if (users != "") {
			//parse la liste des clients
			List<Client> listeClients = JSONArray.parseArray(users, Client.class);
		
			String name = request.getParameter("nom");
			String surname = request.getParameter("prenom");
			String username = request.getParameter("login");
			String password = request.getParameter("mdp");
			String mail = request.getParameter("mail");
			String number = request.getParameter("tel");

			//création nouveau client
			Client client = new Client(name, surname, username, password, mail, number);
			//vérification d'absence de doublons
			boolean same = false;
			for (Client c: listeClients) {
				if (c.getLogin() == client.getLogin()) {
					same = true;
				}
			}
			if (same) {
				request.setAttribute("addingClientMessage", "The client already exists");
			} else {
				request.setAttribute("addingClientMessage", "The client can be added");
				request.setAttribute("clientToAdd", client.toString());
			}
		} else {
			request.setAttribute("addingClientMessage", "The client can be added");
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}
}
