package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.util.*;

import com.infor.cloudsuite.portal.singletenant.agents.services.*;

class CSPUninstallAgent
{
    public void run(HashMap<String, Object> params) throws InterruptedException, CSPAgentService.CommandException
    {
        CSPAgentService service = new CSPAgentService();
        service.uninstall();
    }
}