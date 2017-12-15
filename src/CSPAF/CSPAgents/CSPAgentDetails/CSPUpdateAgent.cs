using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace CSPAF.CSPAgents.CSPAgentDetails
{
    class CSPUpdateAgent
    {
        public void run(Dictionary<string, object> Params)
        {
            var version = (string)Params["Version"];
            var navigationController = CSPBrowser.Application.WindowController.NavigationController;
            var controller = (CSPAgentDetailsController)navigationController.VisibleViewController;
            controller.UpdateAgent(version);
        }
    }
}