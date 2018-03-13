package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;


class CloneInitialStatusCheck{
    public void run(HashMap<String, Object> params){
     
        CSPCloneSuiteController controller=(CSPCloneSuiteController)CSPApplication.getWindowController().getNavigationController().getVisibleViewController();
        controller.statusCheck();   
    }
}