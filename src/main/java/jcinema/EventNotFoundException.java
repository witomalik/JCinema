package jcinema;
/**
 * Class EventNotFoundException
 * Merupakan exception event untuk event yang belum pernah dimasukkan/tidak tersedia
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class EventNotFoundException extends Exception
{
    private int event_error;

    public EventNotFoundException(int event_input){
        super("Event ID ");
        event_error = event_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + event_error + " not found.";
    }
}