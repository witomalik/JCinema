package jcinema;


public class ItemNotFoundException extends Exception
{
    private int item_error;

    public ItemNotFoundException(int item_input){
        super("Item ID ");
        item_error = item_input;
    }

    public String getExMessage()
    {
        return super.getMessage() + item_error + " not found.";
    }
}