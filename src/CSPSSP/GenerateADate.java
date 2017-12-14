package CSPSSP;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;
import java.util.TimeZone;

class GenerateADate{
    public String run(HashMap<String, Object> params){
        String date = null;
        if(params.get("DateType").toString().equals("CreatedDate"))
        {
         SimpleDateFormat CreatedDate = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
        c.add(Calendar.MINUTE, Integer.parseInt(params.get("AddSeconds").toString()));
		date = CreatedDate.format(c.getTime());
        }
        else if(params.get("DateType").toString().equals("CurrentHour"))
        {
         	TimeZone tz = java.util.TimeZone.getTimeZone("GMT+0");
			java.util.Calendar c = java.util.Calendar.getInstance(tz);

		 	date=Integer.toString(c.get(java.util.Calendar.HOUR_OF_DAY));
        }
        else if(params.get("DateType").toString().equals("CurrentMinute"))
        {
         	TimeZone tz = java.util.TimeZone.getTimeZone("GMT+0");
			java.util.Calendar c = java.util.Calendar.getInstance(tz);
			int mm=c.get(java.util.Calendar.MINUTE);
            if(mm>=55)
                date="00";
            else if(mm+5<10)
                date='0'+Integer.toString(mm+5);
            else
            	date = Integer.toString(mm+5);
        }
        else if(params.get("DateType").toString().equals("LastScheduleTime"))
        {
        	SimpleDateFormat CreatedDate = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
			Calendar c = Calendar.getInstance();
			try{
                c.setTime((Date)CreatedDate.parse(params.get("ScheduledTime").toString())); // Now use today date.
                c.add(Calendar.MINUTE, Integer.parseInt(params.get("AddMinutes").toString()));
                date = CreatedDate.format(c.getTime());
            }
            catch(Exception e){}
        }
        else if(params.get("DateType").toString().equals("ScheduledDate"))
        {
        SimpleDateFormat scheduledDate = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
       
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, Integer.parseInt(params.get("AddDays").toString())); // Adding the number of days passed
		date = scheduledDate.format(c.getTime());
        }
        else if(params.get("DateType").toString().equals("ScheduledDateExpected"))
         {
         SimpleDateFormat scheduledDate = new SimpleDateFormat("M/d/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, Integer.parseInt(params.get("AddDays").toString())-1); // Adding the number of days passed
		date = (scheduledDate.format(c.getTime()))+" 11:00 PM";
          }
       return date; 
    }
}