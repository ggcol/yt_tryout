package it.abupro.yt;

import java.util.Scanner;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Main_yt {

	public static void main (String[] args) {

		String repeat;
		System.out.println("===============");
		Scanner s = new Scanner(System.in);

		do {

			System.out.println("digit year: ");
			int year = s.nextInt();
			String safe = s.nextLine();
			Function fun = new Function (year);
			System.out.println(fun.getEaster());
			System.out.println("another? (y/n)");
			repeat = s.nextLine();
			System.out.println("===============");
			
		}while (repeat.equalsIgnoreCase("y"));

		s.close();

	}

}