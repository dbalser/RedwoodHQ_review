using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace actions.CSP.CSPAgents.CSPUtilityServerGroups
{
    class CSPVerifyAgentInstall
    {
        public void run(Dictionary<string, object> Params)
        {
            var service = new CSPAgentService();
            
            if (!service.IsInstalled()) {
                throw new Exception("The agent service has not been installed!");
            }
        }
    }
}