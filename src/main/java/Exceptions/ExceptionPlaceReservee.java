package Exceptions;

/**
 * Représente l'exception quand on essaye de réserver une place déjà réservée
 */
public class ExceptionPlaceReservee extends Exception
{
    public ExceptionPlaceReservee()
    {
        super("Place réservée ; Veuillez vérifier vos informations.");
    }
}
