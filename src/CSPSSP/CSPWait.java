package CSPSSP;

import java.util.*;

class CSPWait{
    public void run(HashMap<String, Object> params){
        
          switch(params.get("WaitType").toString())
		{
		case "ShortWait":
			try{
			Thread.sleep(5000);
			}
			catch(Exception e)
			{
				
			}
			break;
			
		case "MediumWait":
			try{
			Thread.sleep(10000);
			}
			catch(Exception e)
			{
				
			}
			break;
			
		case "LongWait":
			try{
			Thread.sleep(25000);
			}
			catch(Exception e)
			{
				
			}
			break;
              
        case "ExtraLongWait":
			try{
			Thread.sleep(60000);
			}
			catch(Exception e)
			{
				
			}
			break;
	}
        
    }
}