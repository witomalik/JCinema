package jcinema.controller;

import jcinema.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@CrossOrigin(origins = "*", allowedHeaders = "*")   
@RestController
public class CustomerController {

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/registercustomer", method = RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="password") String password,
                            @RequestParam(value = "year", defaultValue = "1900") int year,
                            @RequestParam(value = "month", defaultValue = "01") int month,
                            @RequestParam(value = "dayOfMonth", defaultValue = "01") int dayOfMonth
    )
    {
        Customer customer = new Customer(name, email, password, year, month, dayOfMonth);
        try {
            DatabaseCustomer.addCustomer(customer);
        } catch(Exception ex) {
            ex.getMessage();
            return null;
        }

        return customer;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomer.getCustomer(id);
        return customer;
    }

    @RequestMapping(value="/logincust", method=RequestMethod.POST)
    public Customer loginCust (@RequestParam(value="email") String email,
                               @RequestParam(value="password") String password
    )
    {
        Customer customerReply = DatabaseCustomer.getCustomerLogin(email, password);
        return customerReply;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ArrayList<Customer> custList() {
        return DatabaseCustomer.getCustomerDatabase();
    }


}