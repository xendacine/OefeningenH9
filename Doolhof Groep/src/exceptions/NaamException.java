package exceptions;

public class NaamException extends RuntimeException
{
    public NaamException()
    {
    }
    
    public NaamException(String message)
    {
        super(message);
    }

    public NaamException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NaamException(Throwable cause)
    {
        super(cause);
    }

    public NaamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
