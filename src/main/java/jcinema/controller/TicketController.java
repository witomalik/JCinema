package jcinema.controller;

import jcinema.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TicketController {
    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
    public ArrayList<Ticket> ticketList() {
        return DatabaseTicket.getTicketDatabase();
    }

    @RequestMapping(value = "/ticket/{id_ticket}", method = RequestMethod.GET)
    public Ticket getTicketFromID(@PathVariable int id_ticket) {
        Ticket ticket = DatabaseTicket.getTicketFromID(id_ticket);
        return ticket;
    }

    @RequestMapping(value = "/createticket", method = RequestMethod.POST)
    public Ticket createTicket (@RequestParam(value="idEvent") int idEvent,
                                @RequestParam(value="price") int price,
                                @RequestParam(value="venue") String venue

    ){

            try {
                Category tempcat = Category.valueOf(venue);
                DatabaseTicket.addTicket(new Ticket(DatabaseEvent.getEventFromID(idEvent), price, tempcat));
            } catch(TicketAlreadyExistsException ex) {
                System.out.println(ex.getExMessage());
                return null;
            }

            return DatabaseTicket.getTicketFromID(DatabaseTicket.getLastTicketID());
    }
}
