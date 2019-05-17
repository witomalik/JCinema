package jcinema;
import java.lang.*;
import java.io.*;

public class CustomerNotFoundException extends Exception{
    private int customer_error;

    public CustomerNotFoundException(int customer_input){
        super("Customer ID: ");
        this.customer_error = customer_input;
    }

    public String getExMessage(){
        return super.getMessage() + customer_error +" not found";
    }
}
