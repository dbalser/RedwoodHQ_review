using System;
using System.Linq;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services.RedwoodHQ;

namespace actions.CSP
{
    class CSPCheckIfActionFailed
    {
        public void run(Dictionary<string, object> Params)
        {
            var id = (string)Params["Id"];
            
            //var actionManager = new CSPActionManager();
           	//var action = actionManager.Action(a => a.Name == id);

            //if (action.CurrentState == CSPActionItem.State.NotCompleted)
            //{
            //    action.CurrentState = CSPActionItem.State.Failed;
            //    actionManager.SaveAction(action);
            //}
        }
    }
}