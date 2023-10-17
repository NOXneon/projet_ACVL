package Modele.Utilisateur;

/**
 * Représente un responsable
 */

public abstract class Responsable extends Utilisateur
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
    public Responsable(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        super(nom, prenom, login, mdp, mail, tel);
    }
}
