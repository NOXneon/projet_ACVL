package Modele.Theatre;

import Exceptions.ExceptionChevauchement;
import Exceptions.ExceptionSpectacleExistant;

import java.util.ArrayList;
import java.util.Date;

/**
 * Représente l'instance du théâtre (donc Singleton)
 */
public final class Theatre
{
    /**
     * Instance unique non instanciée
     */
    private static Theatre THEATRE = null;

    /**
     * Représente la salle du théâtre
     */
    private static Salle salle;

    /**
     * Représente la liste des spectacles dans l'organisation
     */
    private static ArrayList<Spectacle> spectacles;

    /**
     * Constructeur
     */
    private Theatre()
    {
        this.salle = Salle.getSALLE();
        this.spectacles = new ArrayList<Spectacle>();
    }

    /**
     * Accès à l'instance unique de Théâtre
     * @return THEATRE : instance unique de Théâtre
     */
    public static synchronized Theatre getTHEATRE()
    {
        if(THEATRE == null)
            THEATRE = new Theatre();

        return THEATRE;
    }

    /**
     * Vérifie que les représentations du spectacle choisie ne chevauchent pas celles des autres spectacles existants
     * @param spectacle : spectacle choisi
     * @return prog_possible : booléen représentant si la programmation du spectacle est possible
     *         (donc toutes ses représentations ne chevauchent aucune autre représentation)
     */
    public boolean progPossible(Spectacle spectacle)
    {
        boolean prog_possible = true;

        for(Representation tmp_representation : spectacle.getRepresentations())
        {
            for(Spectacle tmp_spectacle : spectacles)
            {
                for(Representation tmp_representation1 : tmp_spectacle.getRepresentations())
                {
                    // Calcul de la Date fin du premier spectacle
                    Date endTime_tmp_spectacle = new Date(tmp_representation.getDate().getTime()+tmp_representation.getDuree());
                    if(
                        // Comparaison du chevauchement au niveau de la date
                            tmp_representation.getDate().compareTo(tmp_representation1.getDate()) == 0
                                    ||
                                    // Comparaison du chevauchement au niveau des heures début/fin
                                    endTime_tmp_spectacle.compareTo(tmp_representation1.getDate()) < 0
                    )
                    {
                        prog_possible = false;
                        break;
                    }
                }
            }
        }

        return prog_possible;
    }
    /**
     * Ajoute un spectacle à la liste des spectacles
     * @param spectacle : spectacle à ajouter
     * @throws ExceptionChevauchement : quand il y a un chevauchement de dates
     */
    public void ajouterSpectacle(Spectacle spectacle) throws ExceptionChevauchement, ExceptionSpectacleExistant
    {
    	boolean existant = false;
        if(progPossible(spectacle)) {
        	int i = 0;
        		while (i < spectacles.size() && !existant) {
        			existant = spectacle.getNom().equals(spectacles.get(i).getNom());
        			i++;
        		}
        		if (existant) {
        			throw new ExceptionSpectacleExistant();
        	}
            spectacles.add(spectacle);
        }
        else
            throw new ExceptionChevauchement();
    }

    /**
     * Supprime un spectacle de la liste des spectacles
     * @param spectacle : spectacle à supprimer
     */
    public void supprimerSpectacle(Spectacle spectacle)
    {
        for(Spectacle tmp_spectacle : spectacles)
        {
            if(spectacle.equals(tmp_spectacle))
                spectacles.remove(spectacle);
        }
    }

    /**
     * Getter
     * @return salle : la salle du théâtre
     */
    public static Salle getSalle()
    {
        return salle;
    }

    /**
     * Getter
     * @return spectacles : liste des spectacles programmés dans le théâtre
     */
    public ArrayList<Spectacle> getSpectacles()
    {
        return spectacles;
    }

    /**
     * Retourne les spectacles ainsi que les affiches de leurs représentations
     * @return
     */
    public String planningSpectacles()
    {
        String planning="";

        for(int i=0; i<spectacles.size(); i++)
        {
            planning += spectacles.get(i).getNom() + "\n";
            planning += spectacles.get(i).getAffiches() + "\n";
        }

        return planning;
    }
}
