package jcinema;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Event
{
	protected String title;
	protected int id;
	protected Calendar schedule;


	public Event(String title, int year,int month,int dayOfMonth)
	{
		setTitle(title);
		setSchedule(year, month, dayOfMonth);
		setId();
	}

	public Event(int id, String title, int year,int month,int dayOfMonth)
	{
		setTitle(title);
		setSchedule(year, month, dayOfMonth);
		this.id=id;
	}

	public String getTitle() {
		return title;
	}

	public Calendar getSchedule() {
		return schedule;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId()
	{
		this.id=DatabaseEvent.getLastEventID()+1;
	}

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
