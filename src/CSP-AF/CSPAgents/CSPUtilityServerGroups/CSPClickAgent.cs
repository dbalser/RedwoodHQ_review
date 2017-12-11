using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace actions.CSP.CSPAgents.CSPUtilityServerGroups
{
    class CSPClickAgent
    {
        public void run(Dictionary<string, object> Params)
        {
            var guid = (string)Params["GUID"];
            var index = Int32.Parse((string)Params["Index"]);
            var navigationController = CSPBrowser.Application.WindowController.NavigationController;
            var controller = (CSPUtilityServerGroupsController)navigationController.VisibleViewController;
            controller.ClickAgent(guid);
        }
    }
}