package jcinema;
import java.util.ArrayList;
/**
 * Class DatabaseCustomer
 * Merupakan class databasecustomer dari Cinemania, untuk melihat dan memodifikasi database customer
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class DatabaseCustomer {
    // instance variables
    private static ArrayList<Customer> CUSTOMER_DATABASE = new ArrayList<Customer>();
    private static int LAST_CUSTOMER_ID = 0;

    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk membuat ArrayList berisi customer
     *
     * @return CUSTOMER_DATABASE
     */
    public static ArrayList<Customer> getCustomerDatabase(){
        return CUSTOMER_DATABASE;
    }

    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk mendapatkan ID dari customer terakhir
     *
     * @return LAST_CUSTOMER_ID ID
     *
     */
    public static int getLastCustomerID(){
        return LAST_CUSTOMER_ID;
    }

    /**
     * method untuk menambahkan data customer baru
     * @param customer
     * @return true
     */
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

    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk mendapatkan customer dengan id yang ditentukan
     *
     * @param id
     * @return customer
     */
    public static Customer getCustomer(int id)
    {
        for (Customer customer: CUSTOMER_DATABASE){
            if (customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    /**
     * Accessor untuk object dari class DatabaseCustomer
     * untuk mendapatkan data login customer yang menggunakan email dan password
     *
     * @param email menentukan nilai email
     * @param password menentukan nilai password
     * @return temp
     */
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

    /**
     * Method untuk menghapus data customer.
     * @param id
     *
     * @return true
     */
    public static boolean removeCustomer(int id) throws CustomerNotFoundException {
        for (Customer customer: CUSTOMER_DATABASE){
            if (customer.getId() == id){
                CUSTOMER_DATABASE.remove(customer);
                return true;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    /**
     * Method untuk mengupdate data customer.
     * @param customer
     * @param id
     * @return true
     */
    public static boolean updateCustomer(int id, Customer customer) throws CustomerAlreadyExistsException {
        for (Customer customer1 : CUSTOMER_DATABASE) {
            if (customer1.getId() == id) {
                if (customer1.getName().equals(customer.getName()) || customer1.getEmail().equals(customer.getEmail())) {
                    throw new CustomerAlreadyExistsException(customer1);
                }
            }
            CUSTOMER_DATABASE.set((id - 1), customer);
        }
        return true;
    }
}


