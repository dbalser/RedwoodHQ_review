package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.util.*;

import com.infor.cloudsuite.portal.singletenant.agents.services.*;

class CSPVerifyAgentInstall
{
    public void run(HashMap<String, Object> params) throws Exception
    {
        CSPAgentService service = new CSPAgentService();
            
        if (!service.isInstalled()) {
            throw new Exception("The agent service has not been installed!");
        }
    }
}