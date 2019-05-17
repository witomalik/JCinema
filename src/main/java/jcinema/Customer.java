package jcinema;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;

public class Customer
{
    // instance variables - replace the example below with your own
    private String name;
    private String email;
    private String password;
    private int id;
    private Calendar birthDate;
    

    public Customer(String name,String email,String password,Calendar birthDate)
    {
        // initialise instance variables
        setName(name);
        setEmail(email);
        setPassword(password);
        setId();
        setBirthDate(birthDate);
    }
    
    public Customer(String name,String email,String password,int year,int month,int dayOfMonth)
    {
        // initialise instance variables
        setName(name);
        setEmail(email);
        setPassword(password);
        setId();
        setBirthDate(year, month, dayOfMonth);
    }

    public Customer(int id, String name,String email,String password,int year,int month,int dayOfMonth)
    {
        // initialise instance variables
        setName(name);
        setEmail(email);
        setPassword(password);
        setBirthDate(year, month, dayOfMonth);
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public int getId()
    {
        return id;
    }
    
    public Calendar birthDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        System.out.println("Birth date: "+sdf.format(birthDate.getTime()));
        return birthDate;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }

    public void setEmail(String email)
    {
        String pattern =  "^([a-zA-Z0-9(&*_~)]+([.])?)+[a-zA-Z0-9(&*_~)]+@([a-zA-Z0-9]+[-]?[a-zA-Z0-9]+)+([.]([a-zA-Z0-9]+))+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        if (m.find()) {
            this.email = email;
        } else {
            System.out.println("Email : null");
        }
    }
    
    public void setPassword(String password)
    {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z_0-9]{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        if(m.find()){
            this.password = password;
        }else{
            System.out.println("Password: NULL");
        }
    }
    
    public void setId()
    {
        this.id=DatabaseCustomer.getLastCustomerID()+1;
    }

    public void setBirthDate(Calendar birthDate)
    {
        this.birthDate=birthDate;
        this.birthDate.add(Calendar.MONTH,-1);
    }

    public void setBirthDate(int year,int month,int dayOfMonth)
    {
        this.birthDate=new GregorianCalendar(year,month-1,dayOfMonth);
    }
    
    public String toString()
    {
        return "===Customer==="+
        "\nId: "+id+
        "\nNama: "+name+
        "\nEmail: "+email+
        "\nPassword: "+password;
    }
}
