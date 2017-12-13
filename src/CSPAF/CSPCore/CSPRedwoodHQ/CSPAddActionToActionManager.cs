using System;
using System.Linq;
using System.Threading;
using System.Collections.Generic;
using System.Collections.Concurrent;

using CloudSuitePortal;
using CloudSuitePortal.Services.RedwoodHQ;

namespace actions.CSP
{
    class CSPAddActionToManager
    {
        public void run(Dictionary<string, object> Params)
        {
            var id = (string)Params["Id"];
            var dependencies = ((string)Params["Dependencies"]).Split(',');
            dependencies = dependencies.Contains("None") ? null : dependencies;
            
            var actionManager = new CSPActionManager();
            actionManager.AddAction(id, dependencies);
        }
    }
}