package Modele.Theatre;

/**
 * Repésente une catégorie de zone (unique donc Singleton)
 *
 * @see Zone
 * @see Salle
 */

public final class Orchestre extends Categorie
{
    /**
     * Instance unique non initialisée
     */
    private static Orchestre ORCHESTRE = null;

    /**
     * Concstructeur
     *
     * @param tarif : tarif de la place dans la catégorie de zone
     */
    private Orchestre(float tarif)
    {
        super(tarif);
    }

    /**
     * Point d'accès à l'instance unique de Orchestre
     * @return ORCHESTRE : Catégorie unique
     */
    public static synchronized Orchestre getORCHESTRE()
    {
        if(ORCHESTRE == null)
            ORCHESTRE = new Orchestre(99);

        return ORCHESTRE;
    }
}
