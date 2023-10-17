package Modele.Utilisateur;

import Exceptions.ExceptionPlaceInexistante;
import Exceptions.ExceptionPlaceReservee;
import Exceptions.ExceptionRepresentationInconnue;
import Exceptions.ExceptionZoneInconnue;
import Modele.Billetterie.Achat;
import Modele.Billetterie.Billetterie;
import Modele.Billetterie.Reservation;
import Enums.Etat;
import Modele.Theatre.*;

import java.util.ArrayList;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Représente le client chez le théâtre
 */

public final class Client extends Utilisateur
{
    /**
     * Représente la liste de réservations effectuées
     */
    private ArrayList<Reservation> reservations;

    /**
     * Représente la liste d'achats effectués
     */
    private ArrayList<Achat> achats;

    /**
     * Constructeur
     * @param nom    : nom de l'Utilisateur
     * @param prenom : prénom de l'Utilisateur
     * @param login  : login de l'Utilisateur
     * @param mdp    : mot de passe de l'Utilisateur
     * @param mail   : adresse mail de l'Utilisateur
     * @param tel    : numéro de téléphone de l'Utilisateur
     */
    @JSONCreator
    public Client(@JSONField(name="nom") String nom,@JSONField(name="prenom") String prenom,@JSONField(name="login") String login,@JSONField(name="mdp") String mdp,@JSONField(name="mail") String mail,@JSONField(name="tel") String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
        this.reservations = new ArrayList<Reservation>();
        this.achats = new ArrayList<Achat>();
    }

    /**
     * Getter
     * @return reservations : liste des réservations effectuées
     */
    public ArrayList<Reservation> getReservations()
    {
        return reservations;
    }

    /**
     * Getter
     * @return achats : représente la liste des achats effectués
     */
    public ArrayList<Achat> getAchats()
    {
        return achats;
    }

    /**
     * Réserve une place dans une représentation et zone données
     * @param representation : représentation à assister
     * @param zone : zone de la place
     * @param place : place de la zone
     */
    public Reservation reserverPlace(Representation representation, Zone zone, Place place)
            throws
            ExceptionRepresentationInconnue,
            ExceptionZoneInconnue,
            ExceptionPlaceInexistante,
            ExceptionPlaceReservee
    {
        Reservation reservation = null;
        boolean representation_existante = false;

        if(place.getEtat().equals(Etat.Reservee))
            throw new ExceptionPlaceReservee();
        else
        {
            // Vérification que la représentation existe
            outerloop:
            for(Spectacle tmp_spectacle : Theatre.getTHEATRE().getSpectacles())
            {
                for(Representation tmp_representation : tmp_spectacle.getRepresentations())
                {
                    if(representation.equals(tmp_representation))
                    {
                        representation_existante = true;
                        break outerloop;
                    }
                }
            }

            // Si la représentation existe
            if(representation_existante)
            {
                // Rechercher si la place existe dans la zone

                boolean place_existante = false;

                // zone Balcon
                if(zone.getCategorie() instanceof Balcon)
                {
                    // Recherche de la place
                    for(Place tmp_place : Theatre.getSalle().getZone_Balcon().getPlaces())
                    {
                        // Si la place existe, changer le flag
                        if(place.equals(tmp_place))
                        {
                            place_existante = true;
                            break;
                        }
                    }

                    // La place existe, alors on crée une réservation
                    if(place_existante)
                    {
                        place.setEtat(Etat.Reservee);
                        ArrayList<Place> places = new ArrayList<Place>();
                        places.add(place);
                        reservation = new Reservation(new Date(),places,representation);
                        reservations.add(reservation);
                        Billetterie.getBILLETTERIE().ajouterReservation(reservation);
                        return reservation;
                    }
                    else
                    {
                        throw new ExceptionPlaceInexistante();
                    }
                }
                // zone Poulailler
                else if(zone.getCategorie() instanceof Poulailler)
                {
                    // Recherche de la place
                    for(Place tmp_place : Theatre.getSalle().getZone_Poulailler().getPlaces())
                    {
                        // Si la place existe, changer le flag
                        if(place.equals(tmp_place))
                        {
                            place_existante = true;
                            break;
                        }
                    }

                    // La place existe, alors on crée une réservation
                    if(place_existante)
                    {
                        place.setEtat(Etat.Reservee);
                        ArrayList<Place> places = new ArrayList<Place>();
                        places.add(place);
                        reservation = new Reservation(new Date(),places,representation);
                        reservations.add(reservation);
                        Billetterie.getBILLETTERIE().ajouterReservation(reservation);
                        return reservation;
                    }
                    else
                    {
                        throw new ExceptionPlaceInexistante();
                    }
                }
                else if(zone.getCategorie() instanceof Orchestre)
                {
                    // Recherche de la place
                    for(Place tmp_place : Theatre.getSalle().getZone_Orchestre().getPlaces())
                    {
                        // Si la place existe, changer le flag
                        if(place.equals(tmp_place))
                        {
                            place_existante = true;
                            break;
                        }
                    }

                    // La place existe, alors on crée une réservation
                    if(place_existante)
                    {
                        place.setEtat(Etat.Reservee);
                        ArrayList<Place> places = new ArrayList<Place>();
                        places.add(place);
                        reservation = new Reservation(new Date(),places,representation);
                        reservations.add(reservation);
                        Billetterie.getBILLETTERIE().ajouterReservation(reservation);
                        return reservation;
                    }
                    else
                    {
                        throw new ExceptionPlaceInexistante();
                    }
                }
                else
                {
                    throw new ExceptionZoneInconnue();
                }
            }
            else
            {
                throw new ExceptionRepresentationInconnue();
            }
        }
    }

    /**
     * Annule une réservation
     * @param reservation : réservation à annuler
     */
    public void annulerReservation(Reservation reservation)
    {
        reservations.remove(reservation);
        Billetterie.getBILLETTERIE().supprimerReservation(reservation);
    }

    /**
     * Liste les différentes réservations effectuées
     * @return liste de réservations du client
     */
    public String listerReservations()
    {
        String liste = "";

        for(Reservation tmp_reservation : reservations)
        {
            liste += tmp_reservation.recap() + "\n";
        }

        return liste;
    }

	@Override
	public String toString() {
		String original = super.toString();
		original = original.substring(0,original.length()-1);
		return original+" ,\"reservations\": \"" + reservations + "\", \"achats\": \"" + achats + "\"}";
	}
    
}
