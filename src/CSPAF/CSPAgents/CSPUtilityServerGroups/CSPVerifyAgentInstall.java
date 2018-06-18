package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.util.*;

import com.infor.cloudsuite.portal.singletenant.agents.services.*;

class CSPVerifyAgentInstall
{
    public void run(HashMap<String, Object> params) throws Exception
    {
        CSPAgentServiceController agentServiceController = null;
        
        if (System.getProperty("os.name").contains("Windows")) {
            agentServiceController = new CSPWindowsAgentServiceController();
        }
        else if (System.getProperty("os.name").contains("Linux")) {
            agentServiceController = new CSPLinuxAgentServiceController();
        }
        
        if (!agentServiceController.isInstalled()) { throw new Exception("The agent service has not been installed!"); }
    }
}