using System;
using System.Linq;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;
using CloudSuitePortal.Services.RedwoodHQ;

namespace actions.CSP
{
    class CSPMarkActionAsPassed
    {
        public void run(Dictionary<string, object> Params)
        {
            var id = (string)Params["Id"];
            
            var actionManager = new CSPActionManager();
            var action = actionManager.Action(a => a.Name == id);
            action.CurrentState = CSPActionItem.State.Passed;
            actionManager.SaveAction(action);
        }
    }
}