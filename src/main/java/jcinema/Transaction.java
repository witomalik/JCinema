package jcinema;
import java.util.ArrayList;

public class Transaction
{

    public static void sellTicketPaid(ArrayList<Integer> ticket_list , Customer customer) throws InvoiceAlreadyExistsException {
        ticket_list.add(DatabaseEvent.getLastEventID());
        Invoice inv = new Sell_Paid(ticket_list, customer);
        DatabaseInvoice.addInvoice(inv);
    }

}