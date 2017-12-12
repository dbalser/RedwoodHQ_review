using System;
using System.Linq;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Views;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace actions.CSP.CSPAgents.CSPUtilityServerGroups
{
    class CSPVerifyHeartBeatIsLive
    {
        public void run(Dictionary<string, object> Params)
        {
            var navigationController = CSPBrowser.Application.WindowController.NavigationController;
            var controller = (CSPUtilityServerGroupsController)navigationController.VisibleViewController;
            controller.VerifyAgentHeartBeatIsLive();
        }
    }
}