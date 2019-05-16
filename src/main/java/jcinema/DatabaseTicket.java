package jcinema;
import java.util.ArrayList;

public class DatabaseTicket
{
    // variabel yang digunakan dalam class
    private static ArrayList<Ticket> TICKET_DATABASE = new ArrayList<Ticket>();
    private static int LAST_TICKET_ID=0;
    //public static Ticket ticketDB;

    public static ArrayList<Ticket> getTicketDatabase(){
        return TICKET_DATABASE;
    }

    public static int getLastTicketID(){
        return LAST_TICKET_ID;
    }

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

    public static Ticket getTicketFromID(int id){
        for (Ticket ticket : TICKET_DATABASE) {
            if (id == ticket.getId()) {
                return ticket;
            }
        }
        return null;
    }

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


    public static boolean removeTicket(int id) throws TicketNotFoundException {
        for (Ticket ticket : TICKET_DATABASE) {
            if (id == ticket.getId()) {
                TICKET_DATABASE.remove(ticket);
                return true;
            }
        }
        throw new TicketNotFoundException(id);
    }

}
