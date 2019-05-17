package jcinema;
import java.util.ArrayList;
/**
 * Class DatabaseTicket
 * Merupakan class database ticket dari Cinemania, untuk melihat dan memodifikasi database ticket
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class DatabaseTicket
{
    // variabel yang digunakan dalam class
    private static ArrayList<Ticket> TICKET_DATABASE = new ArrayList<Ticket>();
    private static int LAST_TICKET_ID=0;
    //public static Ticket ticketDB;

    /**
     * Accessor untuk object dari class DatabaseTicket
     * untuk membuat ArrayList berisi ticket
     *
     * @return TICKET_DATABASE
     */
    public static ArrayList<Ticket> getTicketDatabase(){
        return TICKET_DATABASE;
    }

    /**
     * Accessor untuk object dari class DatabaseTicket
     * untuk mendapatkan ID dari ticket terakhir
     *
     * @return LAST_TICKET_ID ID
     *
     */
    public static int getLastTicketID(){
        return LAST_TICKET_ID;
    }

    /**
     * method untuk menambahkan data ticket baru
     * @param ticket
     * @return true
     */
    public static boolean addTicket(Ticket ticket) throws TicketAlreadyExistsException {
        for (Ticket ticket1 : TICKET_DATABASE) {
            if ((ticket.getEvent().equals(ticket1.getEvent())) && (ticket.getCategory()==ticket1.getCategory())) {
                throw new TicketAlreadyExistsException(ticket);
            }
        }
        TICKET_DATABASE.add(ticket);
        LAST_TICKET_ID = ticket.getId();
        return true;
    }

    /**
     * Accessor untuk object dari class DatabaseTicket
     * untuk mendapatkan ticket dengan id yang ditentukan
     *
     * @param id
     * @return ticket
     */
    public static Ticket getTicketFromID(int id){
        for (Ticket ticket : TICKET_DATABASE) {
            if (id == ticket.getId()) {
                return ticket;
            }
        }
        return null;
    }

    /**
     * Accessor untuk object dari class DatabaseTicket
     * untuk mendapatkan ticket dengan event yang ditentukan
     *
     * @param event
     * @return temp
     */
    public static ArrayList<Ticket> getTicketFromEvent(Event event) {
        ArrayList<Ticket> temp = new ArrayList<>();
        for (Ticket ticket : TICKET_DATABASE) {
            if (event.equals(ticket.getEvent())) {
                temp.add(ticket);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else {
            return null;
        }
    }

    /**
     * Accessor untuk object dari class DatabaseTicket
     * untuk mendapatkan ticket dengan category yang ditentukan
     *
     * @param category
     * @return temp
     */
    public static ArrayList<Ticket> getTicketFromCategory(Category category) {
        ArrayList<Ticket> temp = new ArrayList<>();
        for (Ticket ticket : TICKET_DATABASE) {
            if (category.equals(ticket.getCategory())) {
                temp.add(ticket);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else {
            return null;
        }
    }

    /**
     * Method untuk menghapus data ticket.
     * @param id
     *
     * @return true
     */
    public static boolean removeTicket(int id) throws TicketNotFoundException {
        for (Ticket ticket : TICKET_DATABASE) {
            if (id == ticket.getId()) {
                TICKET_DATABASE.remove(ticket);
                return true;
            }
        }
        throw new TicketNotFoundException(id);
    }

    /**
     * Method untuk mengupdate data ticket.
     * @param ticket
     * @param id
     * @return true
     */
    public static boolean updateTicket(int id, Ticket ticket) throws TicketAlreadyExistsException{
        for (Ticket ticket1 : TICKET_DATABASE) {
            if (id == ticket1.getId()) {
                if ((ticket.getEvent().equals(ticket1.getEvent())) && (ticket.getCategory()==ticket1.getCategory())) {
                    throw new TicketAlreadyExistsException(ticket);

                }

            }
            TICKET_DATABASE.set((id-1), ticket);

        }
        return true;
    }


}
