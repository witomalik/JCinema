package jcinema;
import java.util.ArrayList;

public class DatabaseCustomer {
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    public static ArrayList<Customer> getCustomerDatabase(){
        return CUSTOMER_DATABASE;
    }

    public static int getLastCustomerID(){
        return LAST_CUSTOMER_ID;
    }

    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException {
        for (Customer customer1 : CUSTOMER_DATABASE){
            if (customer1.getName().equals(customer.getName()) || customer1.getEmail().equals(customer.getEmail())){
                throw new CustomerAlreadyExistsException(customer1);
            }
        }
        CUSTOMER_DATABASE.add(customer);
        LAST_CUSTOMER_ID=customer.getId();
        return true;
    }

    public static Customer getCustomer(int id)
    {
        for (Customer customer: CUSTOMER_DATABASE){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    public static Customer getCustomerLogin(String email, String password)
    {
        for(Customer temp : CUSTOMER_DATABASE)
        {
            if(temp.getEmail().equals(email) && temp.getPassword().equals(password))
            {
                return temp;
            }
        }
        return null;
    }

    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        for (Customer customer: CUSTOMER_DATABASE){
            if (customer.getId() == id){
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }
}
