package CSPAF.CSPCore.CSPRedwoodHQ;

import java.util.*;

import com.infor.cloudsuite.portal.core.helpers.*;
import com.infor.cloudsuite.portal.core.services.*;

class CSPAddActionToManager
{
    public void run(HashMap<String, Object> params) throws Exception
    {
        String id = params.get("Id").toString();
        List<String> dependencies = Arrays.asList(params.get("Dependencies").toString().split(","));
        dependencies = dependencies.contains("None") ? null : dependencies;
            
        CSPActionManager actionManager = new CSPActionManager();
        actionManager.addAction(id, dependencies);
    }
}