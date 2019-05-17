package jcinema;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.regex.*;
/**
 * Class Customer
 * Merupakan class customer dari Cinemania, untuk membuat customer
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class Customer
{
    // instance variables - replace the example below with your own
    private String name;
    private String email;
    private String password;
    private int id;
    private Calendar birthDate;

    /**
     * Overloading Constructor dari customer
     * @param name berisi name customer
     * @param email berisi email
     * @param password berisi password
     * @param birthDate berisi date
     */
    public Customer(String name,String email,String password,Calendar birthDate)
    {
        // initialise instance variables
        setName(name);
        setEmail(email);
        setPassword(password);
        setId();
        setBirthDate(birthDate);
    }

    /**
     * Overloading Constructor dari customer
     * @param nama berisi name customer
     * @param email berisi email
     * @param password berisi password
     * @param dayOfMonth berisi tanggal
     * @param month berisi bulan
     * @param year berisi tahun
     */
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
    /**
     * Accessor untuk object dari class Customer
     * untuk mendapatkan nilai name.
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor untuk object dari class Customer
     * untuk mendapatkan nilai email.
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Accessor untuk object dari class Customer
     * untuk mendapatkan nilai password.
     *
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Accessor untuk object dari class Customer
     * untuk mendapatkan nilai id.
     *
     * @return id
     */
    public int getId()
    {
        return id;
    }


    /**
     * Accessor untuk object dari class Customer
     * untuk mendapatkan nilai tanggal bertipe Date
     *
     * @return birthDate
     */
    public Calendar birthDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        System.out.println("Birth date: "+sdf.format(birthDate.getTime()));
        return birthDate;
    }

    /**
     * Mutator untuk object dari class Customer
     * untuk menentukan name user
     *
     * @param name berisi nama
     */
    public void setName(String name)
    {
        this.name=name;
    }

    /**
     * Mutator untuk object dari class Customer
     * untuk menentukan email user
     *
     * @param email
     */
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

    /**
     * Mutator untuk object dari class Customer
     * untuk menentukan password user
     *
     * @param password
     */
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

    /**
     * Mutator untuk menginput ID baru berdasarkan id sebelumnya+1
     *
     *
     */
    public void setId()
    {
        this.id=DatabaseCustomer.getLastCustomerID()+1;
    }

    /**
     * Mutator untuk menginput tanggal baru
     *
     * @param birthDate
     */
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
