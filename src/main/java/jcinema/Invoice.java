package jcinema;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Merupakan Class Invoice.
 *
 * @author Muhammad Wito Malik
 * @version 28/02/2019
 */

public abstract class Invoice
{
    // variabel yang digunakan dalam class
    private int id;
    protected ArrayList<Integer> ticket;
    protected int totalPrice;
    private Calendar date;
    private Customer customer;

    public Invoice(ArrayList<Integer> ticket)
    {
        this.id = DatabaseInvoice.getLastInvoiceID() + 1;
        setTicket(ticket);
        for(Integer i : this.ticket)
        {
            totalPrice = totalPrice + DatabaseTicket.getTicketFromID(i.intValue()).getPrice();
        }
        date = GregorianCalendar.getInstance();
    }

    public Invoice(int id, ArrayList<Integer> ticket)
    {
        setTicket(ticket);
        for(Integer i : this.ticket)
        {
            totalPrice = totalPrice + DatabaseTicket.getTicketFromID(i.intValue()).getPrice();
        }
        date = GregorianCalendar.getInstance();
    }

public int getId()
{
    return id;
}

public ArrayList<Integer> getTicket()
{
    return ticket;
}

public Calendar getDate()
{
    return date;
}

public int getTotalPrice()
{
    return totalPrice;
}

public Customer getCustomer()
    {
        return customer;
    }

public void setId (int id)
{
    this.id=id;
}

public void setTicket (ArrayList<Integer> ticket)
{
    this.ticket=ticket;
}

public void setDate (Calendar date)
{
    this.date=date;
}

public void setTotalPrice (int totalPrice) {
    this.totalPrice = totalPrice;
}

public abstract String toString();

}
