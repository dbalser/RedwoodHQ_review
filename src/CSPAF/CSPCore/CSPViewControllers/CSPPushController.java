package CSPAF.CSPCore.CSPViewControllers;

import java.util.*;
import java.lang.reflect.*;

import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;

class CSPPushController
{
    public void run(HashMap<String, Object> params) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        String className = "com.infor.cloudsuite.portal.core.controllers." + params.get("Class Name").toString();

        Class<?> klass = Class.forName(className);
		Constructor<?> constructor = klass.getConstructor();
		CSPViewController controller = (CSPViewController)constructor.newInstance();
        CSPBrowser.getApplication().getWindowController().getNavigationController().push(controller);
    }
}