package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.models.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

class CSPCreateUtilityServerGroup
{
    public void run(HashMap<String, Object> params)
    {
        String name = params.get("Name").toString();
        String region = params.get("Region").toString();
        String description = params.get("Description").toString();
        String amazonCredentials = params.get("Amazon Credentials").toString();
            
        CSPUtilityServerGroup utilityServerGroup = new CSPUtilityServerGroup();
        utilityServerGroup.name = name;
        utilityServerGroup.region = region;
        utilityServerGroup.description = description;
        utilityServerGroup.amazonCredentials = amazonCredentials;
            
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPUtilityServerGroupsController controller = (CSPUtilityServerGroupsController)navigationController.getVisibleViewController();
        controller.create(utilityServerGroup);
    }
}