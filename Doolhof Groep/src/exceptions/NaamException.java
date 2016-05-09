package exceptions;

public class NaamException extends RuntimeException
{
    public NaamException()
    {
    } /** De default exception van naam indien men een foute naam ingeeft**/
    
    public NaamException(String message)
    {
        super(message);
    } /** geeft de fout weer met de super-message **/ 

    public NaamException(String message, Throwable cause)
    {
        super(message, cause);
    }/** Exception die een throwable geeft, gebaseerd op de cause en de meegeleverde message, roept de super constructor van message aan**/

    public NaamException(Throwable cause)
    {
        super(cause);
    } /** Naamexception throwable, roept de super constructor aan: cause**/

    public NaamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    } /** Exception van naam, die de super constructor aanroept bestaande uit message, cause, enableSuppression, writeableStackTrace **/
}
