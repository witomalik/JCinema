package jcinema;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class EventAlreadyExistsException extends Exception
{
    private Event event_error;

    public EventAlreadyExistsException(Event event_input)
    {
        super("Event Name: ");
        event_error = event_input;
    }

    public String getExMessage()
    {
        SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy");
        return super.getMessage() + event_error.getTitle() + " ,Schedule: " + sdf.format(event_error.getSchedule().getTime()) + " already exists.";
    }
}