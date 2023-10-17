package Modele.Theatre;

/**
 * Repésente une catégorie de zone (unique donc Singleton)
 *
 * @see Zone
 * @see Salle
 */
public final class Poulailler extends Categorie
{
    /**
     * Instance unique non initialisée
     */
    private static Poulailler POULAILLER = null;

    /**
     * Concstructeur
     *
     * @param tarif : tarif de la place dans la catégorie de zone
     */
    private Poulailler(float tarif)
    {
        super(tarif);
    }

    /**
     * Point d'accès à l'instance unique de Poulailler
     * @return POULAILLER : Catégorie unique
     */
    public static synchronized Poulailler getPOULAILLER()
    {
        if(POULAILLER == null)
            POULAILLER = new Poulailler(49);

        return POULAILLER;
    }
}
