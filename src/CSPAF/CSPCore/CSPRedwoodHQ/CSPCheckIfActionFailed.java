package CSPAF.CSPCore.CSPRedwoodHQ;

import java.util.*;

import com.infor.cloudsuite.portal.core.helpers.*;
import com.infor.cloudsuite.portal.core.services.*;

class CSPCheckIfActionFailed
{
    public void run(HashMap<String, Object> params) throws Exception
    {
        String id = params.get("Id").toString();
            
        CSPActionManager actionManager = new CSPActionManager();
        CSPActionItem action = actionManager.action(actionItem -> actionItem.name.equals(id));

        if (action == null) { throw new NullPointerException("The action could not be found!"); }
        
        if (action.currentState == CSPActionItem.State.NotCompleted)
        {
        	action.currentState = CSPActionItem.State.Failed;
        	actionManager.saveAction(action);
        }
    }
}