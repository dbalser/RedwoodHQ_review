package CSPAF.CSPAgents.CSPUtilityServerGroups;

import java.io.*;
import java.util.*;
import java.text.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

class CSPVerifyAgentIsLive
{
    public void run(HashMap<String, Object> params) throws IOException, ParseException, CSPUtilityServerGroupsController.VerificationException
    {
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPUtilityServerGroupsController controller = (CSPUtilityServerGroupsController)navigationController.getVisibleViewController();
        controller.verifyAgentHeartBeatIsLive();
    }
}