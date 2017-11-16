package CSPSSP;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

class GenerateADate{
    public String run(HashMap<String, Object> params){
        String date = null;
        if(params.get("DateType").toString().equals("CreatedDate"))
        {
         SimpleDateFormat CreatedDate = new SimpleDateFormat("yyyy-M-d-HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, Integer.parseInt(params.get("AddDays").toString()));
		date = CreatedDate.format(c.getTime());
        }
        else if(params.get("DateType").toString().equals("ScheduledDate"))
        {
         SimpleDateFormat scheduledDate = new SimpleDateFormat("MM/d/yyyy");
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