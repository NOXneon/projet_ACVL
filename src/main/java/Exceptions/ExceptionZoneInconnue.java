package Exceptions;

/**
 * Représente l'exception lors d'un choix de zone hors des 3 prédéfinies
 */
public class ExceptionZoneInconnue extends Exception
{
    public ExceptionZoneInconnue()
    {
        super("Zone inconnue ; Veuillez vérifier vos informations.");
    }
}
