package Modele.Theatre;

import java.util.ArrayList;

/**
 * Représente une zone dans une salle
 *
 * @see Salle
 * @see Categorie
 */

public final class Zone
{
    /**
     * Représente la catégorie
     */
    private Categorie categorie;

    /**
     * Représente la liste des places de la zone
     */
    private ArrayList<Place> places;

    /**
     * Constructeur
     * @param categorie : la catégorie de la zone
     */
    public Zone(Categorie categorie)
    {
        this.categorie = categorie;
        this.places = new ArrayList<Place>();
    }

    /**
     * Constructeur
     * @param categorie : la catégorie de la zone
     * @param places : la liste des places de la zone
     */
    public Zone(Categorie categorie, ArrayList<Place> places)
    {
        this.categorie = categorie;
        this.places = places;
    }

    /**
     * Getter
     * @return categorie : représente la catégorie de la zone
     */
    public Categorie getCategorie()
    {
        return categorie;
    }

    /**
     * Getter
     * @return places : représente la liste des places de la zone
     */
    public ArrayList<Place> getPlaces()
    {
        return places;
    }

    /**
     * Setter
     * @param places : nouvelles liste de places
     */
    public void setPlaces(ArrayList<Place> places)
    {
        this.places = places;
    }
}
