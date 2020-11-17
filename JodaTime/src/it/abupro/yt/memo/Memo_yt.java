package it.abupro.yt.memo;

import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Memo_yt {

	public static void main (String[] args) {

		System.out.println("FORMATTING -----------------------------");
		//formatting 
		//by patterns
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
		//by a String describing "style", first char is for date, second is for time
		//S - SHORT, M - MEDIUM, L - LONG, F - FULL
		DateTimeFormatter fmt2 = DateTimeFormat.forStyle("FS");
		//using Locale (if not used, takes the default for timezone)
		DateTimeFormatter fmt3 = DateTimeFormat.forStyle("LS").withLocale(Locale.ENGLISH);
		
		DateTime toFormat = new DateTime("2016-4-21T20:00");
		
		System.out.println("first formatter: "+fmt.print(toFormat));
		System.out.println("second formatter: "+fmt2.print(toFormat));
		System.out.println("third formatter: "+fmt3.print(toFormat));
		System.out.println();

		System.out.println("INSTANCES -----------------------------");
		//constructor with String - ISO calendar in default timezone
		// yyyy MM dd
		// months are 1 to 12
		DateTime dISO = new DateTime("2010-12-5");
		System.out.println("dISO not formatted:" +dISO.toString());
		System.out.println("builded with String-constructor and formatted print: "+ fmt.print(dISO)); //formatted print
		System.out.println();
		
		//call withDate() method to build date with year, month, day (due to immutability)
		DateTime d1 = new DateTime().withDate(1, 1, 1);
		System.out.println("builded with withDate() and formatted: "+fmt.print(d1));
		System.out.println();

		System.out.println("COMPARATION -----------------------------");
		//comparation through .equals() is not proficient
		DateTime d2 = new DateTime().withDate(1, 1, 1);

		System.out.println(fmt.print(d1)+" and "+fmt.print(d2)+ " are the same 'instant-in-time'?");
		System.out.println(fmt.print(d1).equals(fmt.print(d2))); //true
		System.out.println(fmt.print(d1)+" and "+fmt.print(d2)+ " are the same date?");
		System.out.println(d1.equals(d2)); //sometimes true sometimes false
		
		DateTime d3 = new DateTime().withDate(2015, 8, 24);
		DateTime d4 = new DateTime("2015-8-24");
		
		System.out.println(fmt.print(d3)+" and "+fmt.print(d4)+ " are the same 'instant-in-time'?");
		System.out.println(fmt.print(d3).equals(fmt.print(d4))); //true
		//equality is formatting-related
		System.out.println(fmt.print(d3)+" and "+fmt.print(d4)+ " are the same 'instant-in-time'?");
		System.out.println(fmt.print(d3).equals(fmt2.print(d4))); //it's a traaaap - false
		System.out.println();
		
		
		System.out.println("MANIPULATION -----------------------------");
		DateTime d5 = new DateTime("2018-8-16");
		System.out.println("date do manipulate: "+ fmt.print(d5));
		System.out.println("target is 12 Sept 2019");
		d5.minusDays(4);
		d5.plusMonths(1);
		d5.plusYears(1);
		System.out.println("manipulated date: "+fmt.print(d5)); //don't works due to immutability
		System.out.println("manipulated date: "+fmt.print(d5.minusDays(4).plusMonths(1).plusYears(1))); //this works
		//to persist
		DateTime d6 = d5.minusDays(4).plusMonths(1).plusYears(1);
		System.out.println("manipulated date: "+fmt.print(d6));
		System.out.println();
		
		System.out.println("TIME COMPARATION --------------------------");
		DateTime d7 = new DateTime("2016-7-15T20:00");
		DateTime d8 = new DateTime("2016-7-15T20:30");
		//using fmt3 to show also time
		System.out.println("Is "+fmt3.print(d7)+" before "+fmt3.print(d8)+" ?");
		System.out.println(d7.isBefore(d8));
		System.out.println("Is "+fmt3.print(d7)+" after "+fmt3.print(d8)+" ?");
		System.out.println(d7.isAfter(d8));
	}
}
