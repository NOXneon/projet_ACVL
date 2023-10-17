package Modele.Utilisateur;

import Modele.Billetterie.Billetterie;
import Modele.Billetterie.Reservation;
import Enums.Etat;
import Enums.Statut;
import Modele.Theatre.Place;

/**
 * Représente le responsable de programmation du théâtre
 */

public final class Respo_Application extends Responsable
{
    /**
     * Constructeur
     *
     * @param nom    : nom de l'Utilisateur
     * @param prenom : prénom de l'Utilisateur
     * @param login  : login de l'Utilisateur
     * @param mdp    : mot de passe de l'Utilisateur
     * @param mail   : adresse mail de l'Utilisateur
     * @param tel    : numéro de téléphone de l'Utilisateur
     */
    public Respo_Application(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
    }

    /**
     * Libère les places comprises dans la réservation à annuler
     * @param reservation : réservation à annuler
     */
    public void libererPlace(Reservation reservation)
    {
        // Changer le statut de la réservation
        reservation.setStatut(Statut.Annule_e);

        // Libérer les places
        for(Place tmp_place : reservation.getPlaces())
        {
            tmp_place.setEtat(Etat.Libre);
        }

        // Supprimer la réservation
        Billetterie.getBILLETTERIE().supprimerReservation(reservation);
    }
}
