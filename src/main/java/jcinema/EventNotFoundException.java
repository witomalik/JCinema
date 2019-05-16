package jcinema;
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