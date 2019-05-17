package jcinema;
import java.util.ArrayList;
/**
 * Class Ticket
 * Merupakan class transaction dari Cinemania, untuk membuat transaction
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class Transaction
{

    public static void sellTicketPaid(ArrayList<Integer> ticket_list , Customer customer) throws InvoiceAlreadyExistsException {
        ticket_list.add(DatabaseEvent.getLastEventID());
        Invoice inv = new Sell_Paid(ticket_list, customer);
        DatabaseInvoice.addInvoice(inv);
    }

}