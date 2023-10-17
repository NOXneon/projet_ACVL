package Modele.Billetterie;

import Enums.Statut;
import Modele.Theatre.Place;

import java.util.Date;

/**
 * Représente le ticket émis suite à un achat de place
 *
 * @see Achat
 * @see Modele.Theatre.Place
 * @see Modele.Utilisateur.Client
 * @see Modele.Utilisateur.Respo_Programmation
 */

public final class Ticket
{
    /**
     * Représente le compteur pour créer le num_serie
     */
    private int cpt = 1;

    /**
     * Représente le numéro de série du ticket concernant l'achat de place
     */
    private String num_serie;

    /**
     * Représente la date d'émission du ticket
     */
    private Date date;

    /**
     * Représente le statut du ticket
     */
    private Statut statut;

    /**
     * Représente le dossier d'achat
     */
    private Achat achat;

    /**
     * Représente la place achetée
     */
    private Place place;

    /**
     * Constructeur
     * @param achat : représente le dossier d'achat
     * @param place : représente la place achetée
     */
    public Ticket(Achat achat, Place place)
    {
        this.num_serie = "TK n°"+cpt; cpt++;
        this.date = new Date();
        // Statut par défaut : Valide_e
        this.statut = Statut.Valide_e;
        this.achat = achat;
        this.place = place;
    }

    /**
     * Getter
     * @return num_serie : numéro de série du ticket concernant l'achat de place
     */
    public String getNum_serie()
    {
        return num_serie;
    }

    /**
     * Getter
     * @return date : date d'émission du ticket
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Getter
     * @return statut : statut du ticket
     */
    public Statut getStatut()
    {
        return statut;
    }

    /**
     * Setter
     * @param statut : statut du ticket
     */
    public void setStatut(Statut statut)
    {
        this.statut = statut;
    }

    /**
     * Getter
     * @return achat : représente le dossier d'achat
     */
    public Achat getAchat()
    {
        return achat;
    }

    /**
     * Getter
     * @return place : représente la place achetée
     */
    public Place getPlace()
    {
        return place;
    }

    /**
     * Vérifie si deux tickets sont les mêmes
     * @param obj : deuxième ticket
     * @return vrai si les deux num_serie sont égaux
     */
    @Override
    public boolean equals(Object obj)
    {
        Ticket ticket = (Ticket) obj;

        return this.getNum_serie() == ticket.getNum_serie();
    }
}
