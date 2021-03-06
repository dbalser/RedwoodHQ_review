package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

import org.openqa.selenium.NotFoundException;

class CSPClickAgent
{
    public void run(HashMap<String, Object> params) throws NotFoundException
    {
        String guid = params.get("GUID").toString();
        int index = Integer.parseInt(params.get("Index").toString());
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPUtilityServerGroupsController controller = (CSPUtilityServerGroupsController)navigationController.getVisibleViewController();
        controller.clickAgent(guid);
    }
}