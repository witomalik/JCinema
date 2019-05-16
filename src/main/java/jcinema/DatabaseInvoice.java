package jcinema;
import java.util.ArrayList;

public class DatabaseInvoice
{
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID =0;

    public static Invoice getInvoice(int id){
        for (Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id ){
                return invoice;
            }
        }
        return null;
    }

    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    public static int getLastInvoiceID(){
        return LAST_INVOICE_ID;
    }

    public static boolean addInvoice (Invoice invoice)
            throws InvoiceAlreadyExistsException{
        for(Invoice temp : INVOICE_DATABASE){
            if(invoice.getCustomer() == temp.getCustomer() && invoice.getTicket() == temp.getTicket()){
                throw new InvoiceAlreadyExistsException(invoice);
//                return false;
            }
        }
        INVOICE_DATABASE.add(invoice);
        LAST_INVOICE_ID = invoice.getId();
        return true;
    }


    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoiceDB : INVOICE_DATABASE)
        {
                INVOICE_DATABASE.remove(invoiceDB);
                return true;
        }
        throw new InvoiceNotFoundException(id);
    }

}
