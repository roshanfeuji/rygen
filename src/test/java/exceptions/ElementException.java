package exceptions;

public class ElementException extends RuntimeException{

    public ElementException(String message, Throwable cause){
        super(message, cause);
    }
}
