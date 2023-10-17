package Modele.Theatre;

import Exceptions.ExceptionChevauchement;

import java.util.ArrayList;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * Représente un spectacle mis en scène par le biai de différentes représentations
 *
 * @see Representation
 */

public final class Spectacle
{
    /**
     * Représente le compteur pour créer le numero du spectacle
     */
    private int cpt = 1;

    /**
     * Représete le numéro ID du spectacle
     */
    private String numero;

    /**
     * Représente le nom spectacle
     */
    private String nom;

    /**
     * Représente la liste des représentations du spectacle
     */
    private ArrayList<Representation> representations;

    /**
     * Constructeur paramétré
     * @param nom : nom du spectacle
     * @param representations : liste des représentations
     */
    @JSONCreator
    public Spectacle(@JSONField(name="nom") String nom,@JSONField(name="representations") ArrayList<Representation> representations)
    {
        this.numero = "SPC n°"+cpt; cpt++;
        this.nom = nom;
        this.representations = representations;
    }

    /**
     * Getter
     * @return numero : numéro ID du spectacle
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * Getter
     * @return nom : nom du spectacle
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Getter
     * @return representations : liste des représentations du spectacle
     */
    public ArrayList<Representation> getRepresentations()
    {
        return representations;
    }

    /**
     * Vérifie que la représentation ne chevauche pas les autres représentations du spectacle
     * @param representation : représentation à ajouter
     * @return prog_possible : booléen représentant si la programmation de la représentation est possible
     *                       (donc sa date ne chevauche pas les dates des autres représentations du spectacle)
     */
    public boolean progPossible(Representation representation)
    {
        boolean prog_possible = true;

        for(Representation tmp_representation : representations)
        {
            Date endTime_tmp_representation = new Date(tmp_representation.getDate().getTime()+tmp_representation.getDuree());
            if
            (
                    // égales
                    /*
                    (
                        representation.getDate().getDay()==tmp_representation.getDate().getDay()
                        &&
                        representation.getDate().getMonth()==tmp_representation.getDate().getMonth()
                        &&
                        representation.getDate().getYear()==tmp_representation.getDate().getYear()
                        &&
                        representation.getDate().getHours()==tmp_representation.getDate().getHours()
                        &&
                        representation.getDate().getMinutes()==tmp_representation.getDate().getMinutes()
                    )
                    ||
                    (
                        representation.getDate().getDay()==tmp_representation.getDate().getDay()
                        &&
                        representation.getDate().getMonth()==tmp_representation.getDate().getMonth()
                        &&
                        representation.getDate().getYear()==tmp_representation.getDate().getYear()
                        &&
                        representation.getDate().getHours()==tmp_representation.getDate().getHours()
                        &&
                        representation.getDate().getMinutes()==tmp_representation.getDate()
                    )
                    */

                    representation.getDate().compareTo(tmp_representation.getDate())==0
                    ||
                    (representation.getDate().before(endTime_tmp_representation) && representation.getDate().after(tmp_representation.getDate()))
            )
            {
                prog_possible = false;
                break;
            }
        }

        return prog_possible;
    }

    /**
     *  Ajoute une représentation du spectacle
     * @param representation : représentation à ajouter
     * @throws ExceptionChevauchement : quand il y a un chevauchement de dates
     */
    public void ajouterRepresentation(Representation representation) throws ExceptionChevauchement
    {
        if(progPossible(representation))
            representations.add(representation);
        else
            throw new ExceptionChevauchement();
    }

    /**
     * Supprime une représentation du spectacle
     * @param representation : représentation à supprimer
     */
    public void supprimerRepresentation(Representation representation)
    {
        for(Representation tmp_representation : representations)
        {
            if(representation.equals(tmp_representation))
                representations.remove(representation);
        }
    }

    /**
     * Retourne l'affiche des représentations du spectacle
     * @return
     */
    public String getAffiches()
    {
        String affiches = "";

        for(int i=0; i<representations.size(); i++)
            affiches += representations.get(i).getAffiche();

        affiches += "\n";

        return affiches;
    }

    @Override
    public boolean equals(Object obj)
    {
        Spectacle spectacle = (Spectacle) obj;

        return this.getNom().equals(spectacle.getNom());
    }

	@Override
	public String toString() {
		return "{\"nom\": \"" + nom + "\", \"representations: \"" + representations + "\"}";
	}
    
}
