package jcinema;
import java.lang.*;
import java.io.*;
/**
 * Class CustomerNotFoundException
 * Merupakan exception customer untuk customer yang belum pernah dimasukkan/tidak tersedia
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
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
