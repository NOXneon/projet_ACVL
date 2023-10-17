package Modele.Theatre;

/**
 * Repésente une catégorie de zone (unique donc Singleton)
 *
 * @see Zone
 * @see Salle
 */

public final class Balcon extends Categorie
{
    /**
     * Instance unique non initialisée
     */
    private static Balcon BALCON = null;

    /**
     * Concstructeur
     *
     * @param tarif : tarif de la place dans la catégorie de zone
     */
    private Balcon(float tarif)
    {
        super(tarif);
    }

    /**
     * Point d'accès à l'instance unique de Balcon
     * @return BALCON : Catégorie unique
     */
    public static synchronized Balcon getBALCON()
    {
        if(BALCON == null)
            BALCON = new Balcon(19);

        return BALCON;
    }
}
