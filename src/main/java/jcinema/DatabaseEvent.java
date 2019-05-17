package jcinema;
import java.util.ArrayList;

/**
 * Class DatabaseEvent
 * Merupakan class database event dari Cinemania, untuk melihat dan memodifikasi database event
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class DatabaseEvent
{
    // variabel yang digunakan dalam class
    private static ArrayList<Event> EVENT_DATABASE = new ArrayList<Event>();
    private static int LAST_EVENT_ID=0;
    //public static Event eventDB;

    /**
     * Accessor untuk object dari class DatabaseEvent
     * untuk membuat ArrayList berisi event
     *
     * @return EVENT_DATABASE
     */
    public static ArrayList<Event> getEventDatabase(){
        return EVENT_DATABASE;
    }

    /**
     * Accessor untuk object dari class DatabaseEvent
     * untuk mendapatkan ID dari event terakhir
     *
     * @return LAST_EVENT_ID ID
     *
     */
    public static int getLastEventID(){
        return LAST_EVENT_ID;
    }

    /**
     *  Method untuk object dari class DatabaseEvent
     * untuk menambahkan data invoice baru
     *
     * @param event
     * @return true
     */
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

    /**
     * Accessor untuk object dari class DatabaseEvent
     * untuk mendapatkan event dengan id yang ditentukan
     *
     * @param id
     * @return event
     */
    public static Event getEventFromID(int id){
        for (Event event : EVENT_DATABASE) {
            if (id == event.getId()) {
                return event;
            }
        }
        return null;
    }

    /**
     * Method untuk object dari class DatabaseEvent
     * untuk menghapus event dengan id yang ditentukan
     *
     * @param id
     * @return true
     */
    public static boolean removeEvent(int id) throws EventNotFoundException {
        for (Event event : EVENT_DATABASE) {
            if (id == event.getId()) {
                EVENT_DATABASE.remove(event);
                return true;
            }
        }
        throw new EventNotFoundException(id);
    }

    /**
     * Method untuk mengupdate data event.
     *
     * @param event
     * @param id
     *
     * @return true
     */
    public static boolean updateEvent(int id, Event event) throws EventAlreadyExistsException{
        for (Event event1 : EVENT_DATABASE) {
            if (id == event1.getId()) {
                if ((event.getTitle().equals(event1.getTitle())) && (event.getSchedule().equals(event1.getSchedule()))) {
                    throw new EventAlreadyExistsException(event);

                }

            }
            EVENT_DATABASE.set((id-1), event);

        }
        return true;
    }

}
