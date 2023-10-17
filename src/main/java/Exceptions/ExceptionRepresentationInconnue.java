package Exceptions;

/**
 * Représente l'exception qu'on on sollicite une représentation non existante
 */
public class ExceptionRepresentationInconnue extends Exception
{
    public ExceptionRepresentationInconnue()
    {
        super("Représentation inconnue ; Veuillez vérifier vos informations.");
    }
}
