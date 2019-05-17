package jcinema;

/**
 * Class InvoiceNotFoundException
 * Merupakan exception Invoice untuk invoice yang belum pernah dimasukkan/tidak tersedia
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class InvoiceNotFoundException extends Exception
{
    private int invoice_error;

    public InvoiceNotFoundException(int invoice_input){
        super("Invoice ID ");
        invoice_error = invoice_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + invoice_error + " not found.";
    }
}