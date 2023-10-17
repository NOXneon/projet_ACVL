package Exceptions;

/**
 * Représente l'exception lors d'une programmation contenant un chevauchement entre représentations
 */
public class ExceptionChevauchement extends Exception
{
    public ExceptionChevauchement()
    {
        super("Erreur de programmation ; Veuillez revérifier vos planifications.");
    }
}
