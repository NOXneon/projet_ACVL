package Modele.Utilisateur;

/**
 * Représente un Utilisateur de l'application
 */

public abstract class Utilisateur
{
	/**
     * Représente le nom de l'Utilisateur
     */
    private String nom;

    /**
     * Représente le prénom de l'Utilisateur
     */
    private String prenom;

    /**
     * Représente le login de l'Utilisateur
     */
    private String login;

    /**
     * Représente le mot de passe de l'Utilisateur
     */
    private String mdp;

    /**
     * Représente l'adresse mail de l'Utilisateur
     */
    private String mail;

    /**
     * Représente le numéro de téléphone de l'Utilisateur
     */
    private String tel;

    /**
     * Constructeur
     * @param nom : nom de l'Utilisateur
     * @param prenom : prénom de l'Utilisateur
     * @param login : login de l'Utilisateur
     * @param mdp : mot de passe de l'Utilisateur
     * @param mail : adresse mail de l'Utilisateur
     * @param tel : numéro de téléphone de l'Utilisateur
     */
    public Utilisateur(String nom, String prenom, String login, String mdp, String mail, String tel)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
        this.tel = tel;
    }

    /**
     * Getter
     * @return nom : nom de l'Utilisateur
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Getter
     * @return prenom : prénom de l'Utilisateur
     */
    public String getPrenom()
    {
        return prenom;
    }

    /**
     * Getter login : login de l'Utilisateur
     * @return
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Getter
     * @return mdp ! mot de passe de l'Utilisateur
     */
    public String getMdp()
    {
        return mdp;
    }

    /**
     * Getter
     * @return mail : adresse mail de l'Utilisateur
     */
    public String getMail()
    {
        return mail;
    }

    /**
     * Getter
     * @return tel : numéro de téléphone de l'Utilisateur
     */
    public String getTel()
    {
        return tel;
    }

    @Override
    public String toString()
    {
        return "{\"nom\":\"" + nom + "\", \"prenom\":\"" + prenom + "\", \"login\":\"" + login + "\", \"mdp\":\"" + mdp + "\",\"mail\":\"" + mail
                + "\", \"tel\":\"" + tel+"\"}";
    }

}
