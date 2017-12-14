using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace CSPAF.CSPAgents.CSPUtilityAgents
{
    class CSPClickUtilityAgent
    {
        public void run(Dictionary<string, object> Params)
        {
            var guid = (string)Params["GUID"];
            var navigationController = CSPBrowser.Application.WindowController.NavigationController;
            var controller = (CSPUtilityAgentsController)navigationController.VisibleViewController;
            controller.ClickAgent(guid);
        }
    }
}