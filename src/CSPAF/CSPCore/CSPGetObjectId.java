package CSPAF.CSPCore;

import java.util.*;

import com.infor.cloudsuite.portal.core.helpers.*;
import com.infor.cloudsuite.portal.core.services.*;

class CSPGetObjectId
{
    public String run(HashMap<String, Object> params) throws Exception
    {
       	String prefix = params.get("Prefix").toString();
        String function = params.get("Function").toString();
        String fileName = params.get("File Name").toString();
        String filePath = CSPLogger.projectDirectoryPath() + "\\" + fileName;
            
        List<String> validFunctions = Arrays.asList("get", "increment");
        if (!validFunctions.contains(function.toLowerCase())) { return null; }
        
        CSPLogger<String> logger = new CSPLogger<String>(filePath, String.class);
        logger.create();
        
        CSPDebugHelper.debugPrint("Fetching Ids...");
        
        List<String> ids = logger.fetchObjects();
        
        int numberOfIds = ids.size();
        
        String id = null;
		
      	if (function.toLowerCase().equals("increment"))
        { 
            String suffix = numberOfIds > 0 ? "" + numberOfIds : "0";
           	id = prefix + suffix;
           	logger.log(id);
           	CSPDebugHelper.debugPrint("Logging id: " + id);
       	}
        else if (function.toLowerCase().equals("get") && numberOfIds > 0) {
            id = ids.get(numberOfIds - 1);
        }
        
        return id;
    }
}