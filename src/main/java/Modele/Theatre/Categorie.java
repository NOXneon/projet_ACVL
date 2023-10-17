package Modele.Theatre;

/**
 * Représente la catégorie de zone dans une salle
 *
 * @see Zone
 * @see Salle
 */

public abstract class Categorie
{
    /**
     * tarif de la place dans la catégorie de zone
     * @see Zone
     * @see Place
     */
    private float tarif;

    /**
     * Concstructeur
     * @param tarif : tarif de la place dans la catégorie de zone
     */
    public Categorie(float tarif)
    {
        this.tarif = tarif;
    }

    /**
     * Getter
     * @return tarif : tarif de la place dans la catégorie de zone
     */
    public float getTarif()
    {
        return tarif;
    }
}
