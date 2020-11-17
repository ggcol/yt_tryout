package it.abupro.yt;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Function {

	private int year;
	private DateTime easter;

	public Function (int year) {
		setYear(year);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEaster() {
		easterCalc();

		if (easter.equals(new DateTime().withDate(1, 1, 1))) {
			return "No easter before First Council of Nicaea";
		} else {
			DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
			return "easter date: "+fmt.print(easter);
		}
	}

	public void setEaster(DateTime easter) {
		this.easter = easter;
	}

	public void easterCalc () {

		int g = year%19;
		DateTime easter = new DateTime();

		if (year < 1582 && year > 325) {
			//Julian
			int i = ((19*g)+15)%30;
			int j = ((year+(year/4))+i)%7;
			int l = i-j;
			int month = 3+((l+40)/44);
			int day = l+28-(31*(month/4));
			setEaster(easter.withDate(year, month, day));
		} else if (year >= 1582) {
			//Gregorian
			int c = year/100;
			int h = ((c-c/4-(8*c+13)/25+19*g+15)%30);
			int i = h-(h/28)*(1-(29/(h+1))*((21-g)/11));
			int j = (year+year/4+i+2-c+c/4)%7;
			int l = i-j;
			int month = 3+(l+40)/44;
			int day = l+28-31*(month/4);
			setEaster(easter.withDate(year, month, day));
		} else {
			//no easter before 325 aC
			setEaster(easter.withDate(1, 1, 1));

		}

	}



}
