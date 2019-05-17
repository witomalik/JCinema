package jcinema;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class invoice
 * Merupakan class invoice dari Cinemania, untuk membuat invoice
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
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
        /*
         * method untuk mendapatkan harga dari ticket yang dibeli dari database invoice
         */
        this.id = DatabaseInvoice.getLastInvoiceID() + 1;
        setTicket(ticket);
        for(Integer i : this.ticket)
        {
            totalPrice = totalPrice + DatabaseTicket.getTicketFromID(i.intValue()).getPrice();
        }
        date = GregorianCalendar.getInstance();
    }

    /*
     * method untuk mendapatkan harga dari ticket yang dibeli
     */
    public Invoice(int id, ArrayList<Integer> ticket)
    {
        setTicket(ticket);
        for(Integer i : this.ticket)
        {
            totalPrice = totalPrice + DatabaseTicket.getTicketFromID(i.intValue()).getPrice();
        }
        date = GregorianCalendar.getInstance();
    }

    /**
     * Accessor untuk object dari class Invoice
     * untuk mendapatkan nilai id.
     *
     * @return id
     */
    public int getId()
{
    return id;
}

    /**
     *  Accessor untuk object dari class Invoice
     *  untuk mendapatkan nilai ticket.
     *
     *  @return ticket
     */
    public ArrayList<Integer> getTicket()
{
    return ticket;
}

    /**
     * Accessor untuk object dari class Invoice
     * untuk mendapatkan nilai date.
     *
     * @return date
     */
public Calendar getDate()
{
    return date;
}

    /**
     * Accessor untuk object dari class Invoice
     * untuk mendapatkan nilai totalprice.
     *
     * @return totalPrice
     */
    public int getTotalPrice()
{
    return totalPrice;
}

    /**
     * Accessor untuk object dari class Invoice
     * untuk mendapatkan nilai Customer.
     *
     * @return customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Mutator untuk menginput ID baru
     *
     * @param id
     */
    public void setId (int id)
{
    this.id=id;
}

    /**
     * Mutator untuk menginput Ticket baru
     *
     * @param ticket
     */
    public void setTicket (ArrayList<Integer> ticket)
{
    this.ticket=ticket;
}

    /**
     * Mutator untuk menginput date baru
     *
     * @param date
     */
    public void setDate (Calendar date)
{
    this.date=date;
}

    /**
     * Mutator untuk menginput totalprice baru
     *
     * @param totalPrice
     */
    public void setTotalPrice (int totalPrice) {
    this.totalPrice = totalPrice;
}

    public abstract String toString();

}
