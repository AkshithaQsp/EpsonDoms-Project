package com.Epsondoms.Javalibrary;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;
/**
 * This Class Provides The Resuable Methods To Perform Java-Related Actions
 * -By Calling Inbuild Methods
 * 
 * @author Kallem Akshitha
 * */

public class JavaUtility {
	public static  void pause(long time)
	{
		try
		{
			Thread.sleep(time);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public  static int generateRandomNum(int limit)
	{
		Random random=new Random();
		return random.nextInt(limit);
		
	}
	
	public String getCurrentTime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return sdf.format(date);
	}

}
