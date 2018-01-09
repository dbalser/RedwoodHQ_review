package CSPAF.CSPAgents.CSPAgentDetails;

import java.io.*;
import java.util.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.agents.controllers.*;

import org.openqa.selenium.NotFoundException;

class CSPVerifyAgentCommunication
{
    public void run(HashMap<String, Object> params) throws IOException, NotFoundException, InterruptedException
    {
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPAgentDetailsController controller = (CSPAgentDetailsController)navigationController.getVisibleViewController();
        controller.verifyAgentCommunication();
    }
}