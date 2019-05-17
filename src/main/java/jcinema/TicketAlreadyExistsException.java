package jcinema;
/**
 * Class TicketAlreadyExistsException
 * Merupakan exception Ticket untuk ticket yang sudah ada
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class TicketAlreadyExistsException extends Exception
{
    private Ticket ticket_error;

    public TicketAlreadyExistsException(Ticket ticket_input)
    {
        super("Ticket Name: ");
        ticket_error = ticket_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + ticket_error.getEvent().getTitle() + " ,Category: " + ticket_error.getCategory() + " already exists.";
    }
}