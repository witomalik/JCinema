package jcinema;
import java.io.*;
/**
 * Class CustomerAlreadyExistsException
 * Merupakan exception customer untuk customer yang sudah ada
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class CustomerAlreadyExistsException extends Exception{
    private Customer customer_error;

    public CustomerAlreadyExistsException(Customer customer_input){
        super("Customer Email: ");
        customer_error = customer_input;
    }

    public String getExMessage(){
        return super.getMessage() + customer_error.getEmail() + " or name : " + customer_error.getName() + " already exists.";
    }

}
