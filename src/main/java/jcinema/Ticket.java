package jcinema;
import java.util.*;
import java.text.SimpleDateFormat;
/**
 * Write a description of class Sell_Paid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket
{
    private int price;
    private Event event;
    private Category category;
    private int id;
    
    /**
     * Constructor for objects of class Buy_Paid
     */
    public Ticket (Event event, int price, Category category)
    {
        setEvent(event);
        setPrice(price);
        setCategory(category);
        setId();
    }

    public Ticket (int id, Event event, int price, Category category)
    {
        setEvent(event);
        setPrice(price);
        setCategory(category);
    }
   
    public int getPrice(){
        return price;
    }

    public Event getEvent(){
        return event;
    }

    public Category getCategory(){
        return category;
    }

    public int getId(){
        return id;
    }

    public void setPrice(int price)
    {
        this.price=price;
    }

    public void setEvent(Event event)
    {
        this.event=event;
    }

    public void setCategory(Category category)
    {
        this.category=category;
    }

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
