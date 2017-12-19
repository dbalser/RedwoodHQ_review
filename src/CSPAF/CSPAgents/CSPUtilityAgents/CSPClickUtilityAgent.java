package CSPAF.CSPAgents.CSPUtilityAgents;

import java.util.*;

import com.infor.cloudsuite.portal.core.views.*;
import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

class CSPClickUtilityAgent
{
    public void run(HashMap<String, Object> params) throws CSPTable.RowNotFoundException
    {
        String guid = params.get("GUID").toString();
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPUtilityAgentsController controller = (CSPUtilityAgentsController)navigationController.getVisibleViewController();
        controller.clickAgent(guid);
    }
}