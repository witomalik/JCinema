package jcinema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatabaseEvent
{
    // variabel yang digunakan dalam class
    private static ArrayList<Event> EVENT_DATABASE = new ArrayList<Event>();
    private static int LAST_EVENT_ID=0;
    //public static Event eventDB;

    public static ArrayList<Event> getEventDatabase(){
        return EVENT_DATABASE;
    }

    public static int getLastEventID(){
        return LAST_EVENT_ID;
    }

    public static boolean addEvent(Event event) throws EventAlreadyExistsException {

        for (Event event1 : EVENT_DATABASE) {
            if ((event.getTitle().equals(event1.getTitle())) && (event.getSchedule().equals(event1.getSchedule()))) {
                throw new EventAlreadyExistsException(event);
            }
        }
        EVENT_DATABASE.add(event);
        LAST_EVENT_ID = event.getId();
        return true;
    }

    public static Event getEventFromID(int id){
        for (Event event : EVENT_DATABASE) {
            if (id == event.getId()) {
                return event;
            }
        }
        return null;
    }

    public static boolean removeEvent(int id) throws EventNotFoundException {
        for (Event event : EVENT_DATABASE) {
            if (id == event.getId()) {
                EVENT_DATABASE.remove(event);
                return true;
            }
        }
        throw new EventNotFoundException(id);
    }

}
