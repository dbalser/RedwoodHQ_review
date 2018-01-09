package CSPAF.CSPAgents;

import java.io.*;
import java.util.*;

import com.infor.cloudsuite.portal.singletenant.agents.services.*;

class CSPGetAgentGUID
{
    public String run(HashMap<String, Object> params) throws IOException
    {
        CSPAgentServiceController agentServiceController = null;
        
        if (System.getProperty("os.name").contains("Windows")) {
            agentServiceController = new CSPWindowsAgentServiceController();
        }
        else if (System.getProperty("os.name").contains("Linux")) {
            agentServiceController = new CSPLinuxAgentServiceController();
        }
        
        return agentServiceController.fetchGUID();
    }
}