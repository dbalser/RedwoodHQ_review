package CSPAF.CSPCore.CSPRedwoodHQ;

import java.util.*;

import com.infor.cloudsuite.portal.core.helpers.*;
import com.infor.cloudsuite.portal.core.services.*;

class CSPMarkActionAsPassed
{
    public void run(HashMap<String, Object> params) throws Exception
    {
        String id = params.get("Id").toString();
            
        CSPActionManager actionManager = new CSPActionManager();
        CSPActionItem action = actionManager.action(actionItem -> actionItem.name.equals(id));
        action.currentState = CSPActionItem.State.Passed;
        actionManager.saveAction(action);
    }
}