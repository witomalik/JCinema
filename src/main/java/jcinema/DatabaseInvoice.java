package jcinema;
import java.util.ArrayList;

/**
 * Class DatabaseInvoice
 * Merupakan class database invoice dari Cinemania, untuk melihat dan memodifikasi database invoice
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class DatabaseInvoice
{
    // instance variables - replace the example below with your own
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int LAST_INVOICE_ID =0;

    /**
     * Accessor untuk object dari class DatabaseInvoice
     * untuk mendapatkan invoice dengan id yang ditentukan
     *
     * @param id
     * @return invoice
     */
    public static Invoice getInvoice(int id){
        for (Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id ){
                return invoice;
            }
        }
        return null;
    }

    /**
     * Accessor untuk object dari class DatabaseInvoice
     * untuk membuat ArrayList berisi invoice
     *
     * @return INVOICE_DATABASE
     */
    public static ArrayList<Invoice> getInvoiceDatabase(){
        return INVOICE_DATABASE;
    }

    /**
     * Accessor untuk object dari class DatabaseInvoice
     * untuk mendapatkan ID dari invoice terakhir
     *
     * @return LAST_INVOICE_ID ID
     *
     */
    public static int getLastInvoiceID(){
        return LAST_INVOICE_ID;
    }

    /**
     *  Method untuk object dari class DatabaseInvoice
     * untuk menambahkan data invoice baru
     *
     * @param invoice
     * @return true
     */
    public static boolean addInvoice (Invoice invoice) throws InvoiceAlreadyExistsException{
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

    /**
     * Method untuk object dari class DatabaseInvoice
     * untuk menghapus invoice dengan id yang ditentukan
     *
     * @param id
     * @return true
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoiceDB : INVOICE_DATABASE) {
            if (id == invoiceDB.getId()) {
                INVOICE_DATABASE.remove(invoiceDB);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * Method untuk mengupdate data invoice.
     *
     * @param invoice
     * @param id
     *
     * @return true
     */
    public static boolean updateInvoice (int id, Invoice invoice) throws InvoiceAlreadyExistsException{
        for(Invoice invoiceDB : INVOICE_DATABASE)
        {
            if (id == invoiceDB.getId()) {
                if(invoice.getCustomer() == invoiceDB.getCustomer() && invoice.getTicket() == invoiceDB.getTicket()){
                    throw new InvoiceAlreadyExistsException(invoice);
                }
            }
            INVOICE_DATABASE.set((id-1), invoice);
        }
        return true;
    }

}
