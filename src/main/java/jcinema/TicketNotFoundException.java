package jcinema;
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