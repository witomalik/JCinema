package jcinema.controller;

import jcinema.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class EventController {
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ArrayList<Event> eventList() {
        return DatabaseEvent.getEventDatabase();
    }

    @RequestMapping(value = "/event/{id_event}", method = RequestMethod.GET)
    public Event getEventFromID(@PathVariable int id_event) {
        Event event = DatabaseEvent.getEventFromID(id_event);
        return event;
    }

    @RequestMapping(value = "/createevent", method = RequestMethod.POST)
    public Event createEvent(@RequestParam(value="title") String title,
                             @RequestParam(value="year") int year,
                             @RequestParam(value="month") int month,
                             @RequestParam(value="dayOfMonth") int dayOfMonth

    ){
        Event event = new Event(title, year, month, dayOfMonth);
        try {
            DatabaseEvent.addEvent(event);
        } catch(EventAlreadyExistsException ex) {
            System.out.println(ex.getExMessage());
            return null;
        }

        return event;
    }

    @RequestMapping(value = "/updateevent", method = RequestMethod.POST)
    public Event updateEvent(@RequestParam(value="idEvent") int idEvent,
                             @RequestParam(value="title") String title,
                             @RequestParam(value="year") int year,
                             @RequestParam(value="month") int month,
                             @RequestParam(value="dayOfMonth") int dayOfMonth

    ){
        Event event = new Event(idEvent, title, year, month, dayOfMonth);
        try {
            DatabaseEvent.updateEvent(idEvent, event);
        } catch(EventAlreadyExistsException ex) {
            System.out.println(ex.getExMessage());
            return null;
        }

        return event;
    }
}


