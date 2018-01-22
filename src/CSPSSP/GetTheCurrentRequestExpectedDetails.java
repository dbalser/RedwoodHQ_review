package CSPSSP;
import java.util.*;

class GetTheCurrentRequestExpectedDetails{
    public String[] run(HashMap<String, Object> params){
        
        List<String> currentRequestExpectedDetails = new ArrayList<String>();
		currentRequestExpectedDetails.add(params.get("JobName").toString());
        currentRequestExpectedDetails.add(params.get("RequestedBy").toString());
        currentRequestExpectedDetails.add(params.get("CreatedDate").toString());
        currentRequestExpectedDetails.add(params.get("ScheduledTime").toString());
        currentRequestExpectedDetails.add(params.get("Status").toString());
		
		return currentRequestExpectedDetails.toArray(new String[0]);
    }
}