package jcinema;

/**
 * Class TicketNotFoundException
 * Merupakan exception Ticket untuk ticket yang belum pernah dimasukkan/tidak tersedia
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class TicketNotFoundException extends Exception
{
    private int ticket_error;

    public TicketNotFoundException(int ticket_input){
        super("Ticket ID: ");
        ticket_error = ticket_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + ticket_error + " not found.";
    }
}