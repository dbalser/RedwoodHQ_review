using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

namespace actions.CSP.CSPNavigationBar
{
    class CSPClickUtilityServerGroups
    {
        public void run(Dictionary<string, object> Params)
        {
            var navigationBar = CSPBrowser.Application.WindowController.NavigationBar;
            navigationBar.Administration.Agents.UtilityServerGroups.Click();
        }
    }
}