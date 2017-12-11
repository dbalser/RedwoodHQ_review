using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace actions.CSP.CSPAgents.CSPUtilityServerGroups
{
    class CSPInstallAgentBootstrap
    {
        public void run(Dictionary<string, object> Params)
        {
            var service = new CSPAgentService();
            service.Install();
        }
    }
}