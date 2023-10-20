package Modele.Theatre;

/**
 * Représente la salle du théâtre (donc en Singleton)
 */

public final class Salle
{
    /**
     * Instance unique non initialisée
     */
    private static Salle SALLE = null;

	/**
     * Représente le nombre de places dans la salle
     */
    private static int nb_places = 300;

    /**
     * Représente une des 3 zones de la salle
     */
    private Zone zone_Balcon;

    /**
     * Représente une des 3 zones de la salle
     */
    private Zone zone_Poulailler;

    /**
     * Représente une des 3 zones de la salle
     */
    private Zone zone_Orchestre;

    /**
     * Constructeur
     */
    private Salle()
    {
        this.zone_Balcon = new Zone(Balcon.getBALCON());
        this.zone_Poulailler = new Zone(Poulailler.getPOULAILLER());
        this.zone_Orchestre = new Zone(Orchestre.getORCHESTRE());
    }

    /**
     * Point d'accès à l'instance unique de Salle
     * @return SALLE : Salle unique
     */
    public static synchronized Salle getSALLE()
    {
        if(SALLE == null)
            SALLE = new Salle();

        return SALLE;
    }

    /**
     * Getter
     * @return nb_places : nombre de places dans la salle
     */
    public int getNb_places()
    {
        return nb_places;
    }

    /**
     * Getter
     * @return zone_Balcon : représente la zone Balcon
     */
    public Zone getZone_Balcon()
    {
        return zone_Balcon;
    }

    /**
     * Getter
     * @return zone_Poulailler : représente la zone Poulailler
     */
    public Zone getZone_Poulailler()
    {
        return zone_Poulailler;
    }

    /**
     * Getter
     * @return zone_Orchestre : représente la zone Orchestre
     */
    public Zone getZone_Orchestre()
    {
        return zone_Orchestre;
    }

    public Zone getZone(int index)
    {
        Zone zone = null;
        switch (index)
        {
            case 1:
                zone = getZone_Balcon();
                break;
            case 2:
                zone = getZone_Poulailler();
                break;
            case 3:
                zone = getZone_Orchestre();
                break;
        }

        return zone;
    }

}
