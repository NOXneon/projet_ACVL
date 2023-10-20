package Modele.Theatre;

import Enums.Etat;

/**
 * Représente une place dans la salle
 *
 * @see Salle
 */

public final class Place
{
    /**
     * Représente le numéro de la place
     */
    private String num_place;

    /**
     * Représente le numéro du rang
     */
    private String num_rang;

    /**
     * Représente l'état de la place
     */
    private Etat etat;

    /**
     * tarif de la place dans la catégorie de zone
     * @param num_place : numéro de la place
     * @param num_rang : numéro du rang
     */
    public Place(String num_place, String num_rang)
    {
        this.num_place = num_place;
        this.num_rang = num_rang;
        // Etat par défaut : Libre
        this.etat = Etat.Libre;
    }

    /**
     * Getter
     * @return num_place : numéro de la place
     */
    public String getNum_place()
    {
        return num_place;
    }

    /**
     * Getter
     * @return num_rang : numéro du rang
     */
    public String getNum_rang()
    {
        return num_rang;
    }

    /**
     * Getter
     * @return etat : etat de la place
     */
    public Etat getEtat()
    {
        return etat;
    }

    /**
     * Setter
     * @param etat : etat de la place
     */
    public void setEtat(Etat etat)
    {
        this.etat = etat;
    }

    /**
     * Retourne un descriptif de la place
     * @return desc : descriptif de la place
     */
    public String descriptif()
    {
        String desc = "";

        desc += "Num place : " + this.getNum_place() + "\n"
                + "Num rang : " + this.getNum_rang() + "\n"
                + "Etat : " + this.getEtat() + "\n";

        return desc;
    }

    /**
     *  Compare deux places ; Si les attributs sont les mêmes, alors les places sont les mêmes
     * @param obj : seconde place
     * @return vrai si les différents attributs sont égaux
     */
    @Override
    public boolean equals(Object obj)
    {
        Place place = (Place) obj;

        return this.getNum_rang() == place.getNum_rang()
                &&
                this.getNum_place() == place.getNum_place()
                &&
                this.getEtat() == place.getEtat();
    }
}
