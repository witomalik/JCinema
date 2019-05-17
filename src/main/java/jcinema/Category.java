package jcinema;
/**
 * Enumeration class Category - Merupakan enum dari category yang berisikan category dari jenis ticket yang dibeli
 *  *
 * @author Kelompok 16
 * @version V.1.0
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
