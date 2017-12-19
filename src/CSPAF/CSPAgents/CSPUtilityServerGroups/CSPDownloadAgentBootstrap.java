package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.io.*;
import java.util.*;

import com.infor.cloudsuite.portal.core.views.*;
import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

class CSPDownloadAgentBootstrap
{
    public void run(HashMap<String, Object> params) throws IOException, CSPTable.RowNotFoundException
    {
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPUtilityServerGroupsController controller = (CSPUtilityServerGroupsController)navigationController.getVisibleViewController();
        controller.downloadAgentBootstrap();
    }
}