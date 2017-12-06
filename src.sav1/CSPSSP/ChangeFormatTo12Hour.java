package CSPSSP;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class ChangeFormatTo12Hour{
    public String run(HashMap<String, Object> params){
        Date dateObj=null;
        try{
       	String time=params.get("Hour").toString();
        SimpleDateFormat sdf = new SimpleDateFormat("H");
		dateObj = sdf.parse(time);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		
		return new SimpleDateFormat("K").format(dateObj);
        
    }
}