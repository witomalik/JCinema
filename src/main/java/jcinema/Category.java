package jcinema;
/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Category
{
    VIP("VIP"), Festival("Festival"), Premium("Premium"), Reguler("Reguler");

    String category;
    Category(String category){
    this.category = category;
    }
    
    public String toString(){
    return category;
    }
}
