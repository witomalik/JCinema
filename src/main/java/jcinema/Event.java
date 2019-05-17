package jcinema;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class Event
 * Merupakan class event dari Cinemania, untuk membuat event
 *
 * @author Kelompok 16
 * @version V.1.0 (17/05/19)
 */
public class Event
{
	protected String title;
	protected int id;
	protected Calendar schedule;

	/**
	 * Overloading Constructor dari event
	 *
	 * @param title berisi title dari event
	 * @param year berisi tahun
	 * @param month berisi bulan
	 * @param dayOfMonth berisi tanggal
	 */
	public Event(String title, int year,int month,int dayOfMonth)
	{
		setTitle(title);
		setSchedule(year, month, dayOfMonth);
		setId();
	}

	/**
	 * Overloading Constructor dari event
	 *
	 * @param title berisi title dari event
	 * @param year berisi tahun
	 * @param month berisi bulan
	 * @param dayOfMonth berisi tanggal
	 * @param id
	 */
	public Event(int id, String title, int year,int month,int dayOfMonth)
	{
		setTitle(title);
		setSchedule(year, month, dayOfMonth);
		this.id=id;
	}

	/**
	 * Accessor untuk object dari class Event
	 * untuk mendapatkan nilai title.
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Accessor untuk object dari class Event
	 * untuk mendapatkan nilai scheduler.
	 *
	 * @return schedule
	 */
	public Calendar getSchedule() {
		return schedule;
	}

	/**
	 * Accessor untuk object dari class Event
	 * untuk mendapatkan nilai id.
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Mutator untuk object dari class Event
	 * untuk menentukan title event
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Mutator untuk menginput ID baru berdasarkan id sebelumnya +1
	 *
	 *
	 */
	public void setId()
	{
		this.id=DatabaseEvent.getLastEventID()+1;
	}

	/**
	 * Mutator untuk object dari class Event
	 * untuk menentukan schedule event
	 *
	 * @param dayOfMonth
	 * @param month
	 * @param year
	 */
	public void setSchedule(int year,int month,int dayOfMonth)
	{
		this.schedule=new GregorianCalendar(year,month-1,dayOfMonth);
	}

	public String toString()
	{
       /*for (int tmp : this.getItem())
       {
           System.out.println(DatabaseEvent.getItemFromID(tmp).toString());
       }*/
		SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy");

		return "\n========Event========" +
				"\nID: " +  getId() +
				"\nTitle: " + getTitle() +
				"\nSchedule: " + sdf.format(getSchedule().getTime()) +
				"\nTicket Success\n";
	}


}
