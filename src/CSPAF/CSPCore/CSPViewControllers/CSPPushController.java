package CSPAF.CSPCore.CSPViewControllers;

import java.util.*;
import java.lang.reflect.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;

class CSPPushController
{
    public void run(HashMap<String, Object> params) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        String thePackage = "com.infor.cloudsuite.portal." + params.get("Package").toString();
        String className = thePackage + ".controllers." + params.get("Class").toString();

		CSPViewController controller = (CSPViewController)Class.forName(className).newInstance();
        CSPBrowser.getApplication().getWindowController().getNavigationController().push(controller);
    }
}