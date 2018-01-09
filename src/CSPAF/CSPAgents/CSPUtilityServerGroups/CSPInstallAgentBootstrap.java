package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeoutException;

import com.infor.cloudsuite.portal.singletenant.agents.services.*;

class CSPInstallAgentBootstrap
{
    public void run(HashMap<String, Object> params) throws IOException, InterruptedException, TimeoutException
    {
        CSPAgentServiceController agentServiceController = null;
        
        if (System.getProperty("os.name").contains("Windows")) {
           	agentServiceController = new CSPWindowsAgentServiceController();
        }
        else if (System.getProperty("os.name").contains("Linux")) {
            agentServiceController = new CSPLinuxAgentServiceController();
        }
        
        agentServiceController.install();
    }
}