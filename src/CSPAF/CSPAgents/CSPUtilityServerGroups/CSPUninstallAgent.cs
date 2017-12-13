using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace CSPAF.CSPAgents.CSPUtilityServerGroups
{
    class CSPUninstallAgent
    {
        public void run(Dictionary<string, object> Params)
        {
            var service = new CSPAgentService();
            service.Uninstall();
        }
    }
}