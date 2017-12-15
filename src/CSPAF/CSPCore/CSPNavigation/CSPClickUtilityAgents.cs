using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

namespace CSPAF.CSPCore.CSPNavigation
{
    class CSPClickUtilityAgents
    {
        public void run(Dictionary<string, object> Params)
        {
            var navigationBar = CSPBrowser.Application.WindowController.NavigationBar;
            navigationBar.Administration.Agents.UtilityAgents.Click();
        }
    }
}