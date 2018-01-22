package CSPSSP;

import java.text.SimpleDateFormat;
import java.util.*;


class CSPGenerateDate_ServiceRequest{
    public String run(HashMap<String, Object> params){
        SimpleDateFormat timeFormat = new SimpleDateFormat("M/d/yyyy");
        Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String date = timeFormat.format(c.getTime());
        System.out.println("_________________>>>>>>>>>>>>>>>>    "+date);
        return date;
    }
}