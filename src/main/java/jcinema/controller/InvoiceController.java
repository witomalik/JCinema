package jcinema.controller;

import jcinema.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InvoiceController {

    @RequestMapping(value = "/invoice/{id_invoice}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable int id_invoice) {
        Invoice invoice = DatabaseInvoice.getInvoice(id_invoice);
        return invoice;
    }

    @RequestMapping(value = "/createinvoicepaid", method = RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value="listTicket") ArrayList<Integer> listTicket,
                                     @RequestParam(value="customerID") int customerID
    ){
        try{
            boolean tmp = DatabaseInvoice.addInvoice(new Sell_Paid(listTicket, DatabaseCustomer.getCustomer(customerID)));
            if (tmp == true) {
                return DatabaseInvoice.getInvoice(DatabaseInvoice.getLastInvoiceID());
            }
        } catch (InvoiceAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        return null;
    }

}
