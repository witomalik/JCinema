package jcinema;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class main Cinemania
 * Merupakan aplikasi utama dari Cinemania
 *
 * @author Kelompok 16
 * @version V.1.0
 */
@SpringBootApplication

public class Cinemania
{
    /**
     * program utama Cinemania
     *
     * @param args argumen
     */
    public static void main(String[] args) {
        SpringApplication.run(Cinemania.class, args);

        try {
            DatabaseCustomer.addCustomer(new Customer("Djati", "Djati@gmail.com", "Abc1234", 2019, 9, 10));
            DatabaseCustomer.addCustomer(new Customer("Djati", "Djati@gmail.com", "Abc1234", 2019, 9, 10));
        }
        catch (CustomerAlreadyExistsException e) {
            System.out.println("===Customer Already Exists===");
            System.out.println(e.getExMessage());
            System.out.println();
        }

        try {
            DatabaseEvent.addEvent(new Event("Konser Musik", 2019, 06, 20));
            DatabaseEvent.addEvent(new Event("Konser Musik", 2019, 06, 20));
        }
        catch (EventAlreadyExistsException e) {
            System.out.println("===Event Already Exists===");
            System.out.println(e.getExMessage());
            System.out.println();
        }

        try {
            DatabaseTicket.addTicket(new Ticket(DatabaseEvent.getEventFromID(1), 250000, Category.Reguler));
            DatabaseTicket.addTicket(new Ticket(DatabaseEvent.getEventFromID(1), 250000, Category.Reguler));
        }
        catch (TicketAlreadyExistsException e) {
            System.out.println("===Ticket Already Exists===");
            System.out.println(e.getExMessage());
            System.out.println();
        }

        System.out.println(DatabaseCustomer.getCustomerDatabase());
        System.out.println();
        System.out.println(DatabaseEvent.getEventDatabase());
        System.out.println();
        System.out.println(DatabaseTicket.getTicketDatabase());
        System.out.println();

        try {
            DatabaseCustomer.removeCustomer(2);
        } catch (CustomerNotFoundException e) {
            System.out.println("===Customer Not Found===");
            System.out.println(e.getExMessage());
            System.out.println();
        }

        try {
            DatabaseEvent.removeEvent(2);
        } catch (EventNotFoundException e) {
            System.out.println("===Event Not Found===");
            System.out.println(e.getExMessage());
            System.out.println();
        }

        try {
            DatabaseTicket.removeTicket(2);
        } catch (TicketNotFoundException e) {
            System.out.println("===Ticket Not Found===");
            System.out.println(e.getExMessage());
            System.out.println();
        }

    }
}
