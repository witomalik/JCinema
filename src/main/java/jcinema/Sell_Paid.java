package jcinema;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Class Sell_Paid
 * Merupakan subclass Invoice, untuk membuat pembayaran Sell_paid
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class Sell_Paid extends Invoice
{
    // instance variables - replace the example below with your own
    private Customer customer;
    private boolean isActive;

    /**
     * Constructor dari Sell_Paid
     *
     * @param customer
     * @param ticket
     */
    public Sell_Paid(ArrayList<Integer> ticket, Customer customer)
    {
        super(ticket);
        this.customer = customer;
    }

    /**
     * Accessor untuk object dari class Sell_Paid
     * untuk mendapatkan nilai Customer.
     *
     * @return customer
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * Mutator untuk object dari class Sell_Paid
     * untuk menentukan nilai customer.
     *
     * @param customer
     */
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat ("dd MMM yyyy");

        for (int bar : this.getTicket()){
            System.out.println(DatabaseTicket.getTicketFromID(bar));
        }

        return "====Sell Paid=== \nID= "+this.getId()+
// "\nTicket= "+this.getTicket().getId()+
//        "\nAmount "+this.getTotalTicket()+
                "\nBuy Date: "+sdf.format(getDate().getTime())+
                // "\nPrice= "+this.getTicket().getPrice()+
                "\nPrice Total: "+getTotalPrice()+
                // "\nSupplier Id: "+this.getTicket().getSupplier().getId()+
                // "\nSupplier Name= "+ this.getTicket().getSupplier().getName() +
                "\nCustomer ID= "+ getCustomer().getId() +
                "\nCustomer Name= "+ getCustomer().getName() +
                "\nSell Success\n";
    }
}
