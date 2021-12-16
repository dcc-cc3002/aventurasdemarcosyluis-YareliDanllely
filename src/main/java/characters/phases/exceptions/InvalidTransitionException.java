package characters.phases.exceptions;

/**
 * Se creo un metodo de exepcion para el erroneo movimiento entre fases
 */
public class InvalidTransitionException extends Exception {
    public InvalidTransitionException(final String message){super(message);}
}
