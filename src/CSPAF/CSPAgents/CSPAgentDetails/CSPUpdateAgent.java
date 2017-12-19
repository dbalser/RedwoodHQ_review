package CSPAF.CSPAgents.CSPAgentDetails;

import java.io.*;
import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

class CSPUpdateAgent
{
    public void run(HashMap<String, Object> params) throws IOException
    {
        String version = params.get("Version").toString();
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPAgentDetailsController controller = (CSPAgentDetailsController)navigationController.getVisibleViewController();
        controller.updateAgent(version);
    }
}