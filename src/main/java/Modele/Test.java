package Modele;

import Exceptions.*;
import Modele.Billetterie.Reservation;
import Modele.Theatre.*;
import Modele.Utilisateur.Client;
import Modele.Utilisateur.Respo_Application;
import Modele.Utilisateur.Respo_Programmation;
import Modele.Utilisateur.Utilisateur;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        //------------------------- Création du théâtre -------------------------
        Theatre theatre = Theatre.getTHEATRE();
        //------------------------- Fin création du théâtre -------------------------

        //------------------------- Création des places -------------------------
        // Rang 1
        Place place11 = new Place("1","1");
        Place place21 = new Place("2","1");
        Place place31 = new Place("3","1");
        // Rang 2
        Place place12 = new Place("1","1");
        Place place22 = new Place("2","1");
        Place place32 = new Place("3","1");
        // Rang 3
        Place place13 = new Place("1","1");
        Place place23 = new Place("2","1");
        Place place33 = new Place("3","1");
        //------------------------- Fin création des places -------------------------

        //------------------------- Attribution des places aux zones -------------------------
        // Balcon
        ArrayList<Place> places_Balcon = new ArrayList<Place>();
        places_Balcon.add(place11);
        places_Balcon.add(place21);
        places_Balcon.add(place31);
        Theatre.getSalle().getZone_Balcon().setPlaces(places_Balcon);
        // Poulailler
        ArrayList<Place> places_Poulailler = new ArrayList<Place>();
        places_Poulailler.add(place12);
        places_Poulailler.add(place22);
        places_Poulailler.add(place32);
        Theatre.getSalle().getZone_Poulailler().setPlaces(places_Poulailler);
        // Orchestre
        ArrayList<Place> places_Orchestre = new ArrayList<Place>();
        places_Orchestre.add(place13);
        places_Orchestre.add(place23);
        places_Orchestre.add(place33);
        Theatre.getSalle().getZone_Orchestre().setPlaces(places_Orchestre);
        //------------------------- Fin attribution des places aux zones -------------------------

        //------------------------- Création des spectacles -------------------------
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 26);
        //------ Spectacle 1 ------
        // Création des représentations
        calendar.set(Calendar.HOUR, 17);
        calendar.set(Calendar.MINUTE, 0);
        Representation representation1 = new Representation(calendar.getTime(), 90);
        ArrayList<Representation> representations_spectacle1 = new ArrayList<Representation>();
        representations_spectacle1.add(representation1);
        Spectacle spectacle1 = new Spectacle("Spectacle A", representations_spectacle1);
        //------ Fin spectacle 1 ------

        //------ Spectacle 2 ------
        // Création des représentations
        calendar.set(Calendar.HOUR, 18);
        calendar.set(Calendar.MINUTE, 31);
        Representation representation2 = new Representation(calendar.getTime(), 120);
        ArrayList<Representation> representations_spectacle2 = new ArrayList<Representation>();
        representations_spectacle2.add(representation2);
        Spectacle spectacle2 = new Spectacle("Spectacle B",representations_spectacle2);
        //------ Fin spectacle 2 ------

        //------ Spectacle 3 ------
        // Création des représentations
        calendar.set(Calendar.HOUR, 20);
        calendar.set(Calendar.MINUTE, 32);
        Representation representation3 = new Representation(calendar.getTime(), 90);
        ArrayList<Representation> representations_spectacle3 = new ArrayList<Representation>();
        representations_spectacle3.add(representation3);
        Spectacle spectacle3 = new Spectacle("Spectacle C",representations_spectacle3);
        //------ Fin spectacle 3 ------

        //------------------------- Fin création des spectacles -------------------------

        //------------------------- Attribution des spectacles -------------------------
        try
        {
            theatre.ajouterSpectacle(spectacle1);
            theatre.ajouterSpectacle(spectacle2);
			theatre.ajouterSpectacle(spectacle3);
		}
        catch (ExceptionSpectacleExistant e)
        {
				e.printStackTrace();
        } catch (ExceptionChevauchement exceptionChevauchement)
        {
            exceptionChevauchement.printStackTrace();
        }
        //------------------------- Fin attribution des spectacles -------------------------

        //------------------------- Création des utilisateurs -------------------------
        Utilisateur client = new Client("GRISSI","Wafi","neon","noxus","neon@gmail.com","7777777777");
        //------------------------- Fin création des utilisateurs -------------------------

        try
        {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            outerloop:
            while (flag)
            {
                System.out.println("Liste des spectacles");
                System.out.println(theatre.planningSpectacles());

                System.out.println("Pour quel spectacle voulez vous réserver une place ? (tapez le nom correspondant)");
                for(Spectacle s : theatre.getSpectacles())
                    System.out.println(s.getNom());

                String spec_choisi = sc.nextLine();
                if(spec_choisi.equals("exit"))
                {
                    flag = false;
                    break outerloop;
                }

                int index_spec_choisi = 0;

                if(spec_choisi.equalsIgnoreCase("Spectacle A"))
                    index_spec_choisi = 1;

                if(spec_choisi.equalsIgnoreCase("Spectacle B"))
                    index_spec_choisi = 2;

                if(spec_choisi.equalsIgnoreCase("Spectacle C"))
                    index_spec_choisi = 3;

                System.out.println("Dans quelle zone voulez-vous une place ? \n1- Balcon\n2- Poulailler\n3- Orchestre");

                int zone_choisie = Integer.parseInt(sc.nextLine());
                if(spec_choisi.equals("exit"))
                {
                    flag = false;
                    break outerloop;
                }

                switch (zone_choisie)
                {
                    case 1:
                        System.out.println("Places en balcon :");
                        for(Place p : Theatre.getSalle().getZone_Balcon().getPlaces())
                            System.out.println(p.descriptif());
                        break;
                    case 2:
                        System.out.println("Places en poulailler :");
                        for(Place p : Theatre.getSalle().getZone_Poulailler().getPlaces())
                            System.out.println(p.descriptif());
                        break;
                    case 3:
                        System.out.println("Places en orchestre :");
                        for(Place p : Theatre.getSalle().getZone_Orchestre().getPlaces())
                            System.out.println(p.descriptif());
                        break;
                }

                System.out.println("Quelle place voulez vous ? (entrer deux digits, premier numéro de place, second numéro de rang. Exemple : 11)");

                String place_choisie = sc.nextLine();
                if(spec_choisi.equals("exit"))
                {
                    flag = false;
                    break outerloop;
                }

                String num_place = Character.toString(place_choisie.charAt(0));
                String num_rang = Character.toString(place_choisie.charAt(1));

                Place place = null;
                switch (zone_choisie)
                {
                    case 1:
                        for(Place p : Theatre.getSalle().getZone_Balcon().getPlaces())
                        {
                            if(p.getNum_place().equals(num_place) && p.getNum_rang().equals(num_rang))
                            {
                                System.out.println("Place choisie :");
                                System.out.println(p.descriptif());
                                place = p;
                            }
                        }
                        break;
                    case 2:
                        for(Place p : Theatre.getSalle().getZone_Poulailler().getPlaces())
                        {
                            if(p.getNum_place().equals(num_place) && p.getNum_rang().equals(num_rang))
                            {
                                System.out.println("Place choisie :");
                                System.out.println(p.descriptif());
                                place = p;
                            }
                        }
                        break;
                    case 3:
                        for(Place p : Theatre.getSalle().getZone_Orchestre().getPlaces())
                        {
                            if(p.getNum_place().equals(num_place) && p.getNum_rang().equals(num_rang))
                            {
                                System.out.println("Place choisie :");
                                System.out.println(p.descriptif());
                                place = p;
                            }
                        }
                        break;
                }

                Spectacle spectacle = theatre.getSpectacle(spec_choisi);

                switch (index_spec_choisi)
                {
                    case 1:
                        System.out.println("Spectacle A");
                        System.out.println("Représentations :");
                        int index = 1;
                        for(Representation r : spectacle.getRepresentations())
                        {
                            System.out.println(index + ")\n" + r.getAffiche());
                            index++;
                        }
                        break;
                    case 2:
                        System.out.println("Spectacle B");
                        System.out.println("Représentations :");
                        index = 1;
                        for(Representation r : spectacle.getRepresentations())
                        {
                            System.out.println(index + ")\n" + r.getAffiche());
                            index++;
                        }
                        break;
                    case 3:
                        System.out.println("Spectacle C");
                        System.out.println("Représentations :");
                        index = 1;
                        for(Representation r : spectacle.getRepresentations())
                        {
                            System.out.println(index + ")\n" + r.getAffiche());
                            index++;
                        }
                        break;
                }

                System.out.println("Quelle représentation voulez-vous choisir ? (veuillez choisir le numéro, exemple : 1)");
                int rep_choisie = Integer.parseInt(sc.nextLine());

                if(spec_choisi.equals("exit"))
                {
                    flag = false;
                    break outerloop;
                }

                System.out.println("Réservation : ");
                Representation representation = spectacle.getRepresentations().get(rep_choisie-1);
                Zone zone = Theatre.getSalle().getZone(zone_choisie);

                Reservation reservation = ((Client) client).reserverPlace(representation, zone, place);
                System.out.println("Récap");
                System.out.println(reservation.recap());
                System.out.println("Fin récap");

                System.out.println("Voulez vous annuler ?\n1) Oui\n 2) Non");
                int annul_index = Integer.parseInt(sc.nextLine());

                switch (annul_index)
                {
                    case 1:
                        System.out.println("Annulation de la réservation");
                        ((Client) client).annulerReservation(reservation);
                        System.out.println("Liste des réservations du client");
                        System.out.println(((Client) client).listerReservations());
                        break;
                    case 2:
                        break;
                }

                flag = false;
            }

            /*
            System.out.println("Places :");
            System.out.println("Balcon :");
            for(Place p : Theatre.getSalle().getZone_Balcon().getPlaces())
                System.out.println(p.descriptif());

            System.out.println("Réservation : ");
            System.out.println("Pour quel spectacle voulez-vous effectuer une réservation ?");
            Reservation reservation = ((Client) client).reserverPlace(representation1, Theatre.getSalle().getZone_Balcon(), place11);
            System.out.println("Récap");
            System.out.println(reservation.recap());
            System.out.println("Fin récap");

            System.out.println("Réservation : ");
            Reservation reservation1 = ((Client) client).reserverPlace(representation1, Theatre.getSalle().getZone_Balcon(), place21);
            System.out.println("Récap");
            System.out.println(reservation1.recap());
            System.out.println("Fin récap");

            System.out.println("Annulation de la réservation");
            ((Client) client).annulerReservation(reservation1);
            System.out.println("Liste des réservations du client");
            System.out.println(((Client) client).listerReservations());

            System.out.println("Liste des réservations du client");
            System.out.println(((Client) client).listerReservations());
            // Test de réservation d'une place déjà réservée
            //Reservation reservation1 = ((Client) client).reserverPlace(representation1, Theatre.getSalle().getZone_Balcon(), place11);
            System.out.println("Annulation de la réservation");
            ((Client) client).annulerReservation(reservation);
            System.out.println("Liste des réservations du client");
            System.out.println(((Client) client).listerReservations());
             */

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
