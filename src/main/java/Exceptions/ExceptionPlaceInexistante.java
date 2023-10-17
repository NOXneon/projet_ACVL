package Exceptions;

/**
 * Représente l'exception lors d'une recherche d'une place inexistante
 */
public class ExceptionPlaceInexistante extends Exception
{
    public ExceptionPlaceInexistante()
    {
        super("Place inexistante ; Veuillez vérifier vos informations.");
    }
}
