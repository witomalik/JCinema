package jcinema;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Class Ticket
 * Merupakan class ticket dari Cinemania, untuk membuat ticket
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class Ticket
{
    private int price;
    private Event event;
    private Category category;
    private int id;

    /**
     * Constructor dari ticket
     *
     * @param category
     * @param event
     * @param price
     *
     */
    public Ticket (Event event, int price, Category category)
    {
        setEvent(event);
        setPrice(price);
        setCategory(category);
        setId();
    }

    /**
     * Constructor dari ticket
     *
     * @param category
     * @param event
     * @param price
     * @param id
     */
    public Ticket (int id, Event event, int price, Category category)
    {
        setEvent(event);
        setPrice(price);
        setCategory(category);
    }

    /**
     * Accessor untuk object dari class Ticket
     * untuk mendapatkan nilai price.
     *
     * @return price
     */
    public int getPrice(){
        return price;
    }


    /**
     * Accessor untuk object dari class Ticket
     * untuk mendapatkan nilai event.
     *
     * @return event
     */
    public Event getEvent(){
        return event;
    }


    /**
     * Accessor untuk object dari class Ticket
     * untuk mendapatkan nilai category.
     *
     * @return category
     */
    public Category getCategory(){
        return category;
    }


    /**
     * Accessor untuk object dari class Ticket
     * untuk mendapatkan nilai id.
     *
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Mutator untuk object dari class Ticket
     * untuk menentukan price
     *
     * @param price
     */
    public void setPrice(int price)
    {
        this.price=price;
    }

    /**
     * Mutator untuk object dari class Ticket
     * untuk menentukan event
     *
     * @param event
     */
    public void setEvent(Event event)
    {
        this.event=event;
    }

    /**
     * Mutator untuk object dari class Ticket
     * untuk menentukan category
     *
     * @param category
     */
    public void setCategory(Category category)
    {
        this.category=category;
    }

    /**
     * Mutator untuk object dari class Ticket
     * untuk menentukan Id berdasarkan id sebelumnya +1
     *
     *
     */
    public void setId() {
        this.id = DatabaseTicket.getLastTicketID() + 1;
    }

    public String toString()
    {
       /*for (int tmp : this.getItem())
       {
           System.out.println(DatabaseEvent.getItemFromID(tmp).toString());
       }*/
       SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy");

       return "\n========Ticket========" +
              "\nID: " +  event.getId() +
              "\nEvent: " + getEvent() +
               "\nPrice: " + getPrice() +
              "\nCategory: " + getCategory() +
              "\nTicket Success\n";
    }
}
