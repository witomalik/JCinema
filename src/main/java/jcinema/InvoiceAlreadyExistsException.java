package jcinema;

public class InvoiceAlreadyExistsException extends Exception
{
    private Invoice invoice_error;

    public InvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Invoice with Ticket list : ");
        invoice_error = invoice_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + invoice_error.getTicket() + " already ordered by " + invoice_error.getCustomer().getName();
    }
}