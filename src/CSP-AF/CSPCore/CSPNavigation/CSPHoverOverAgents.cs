using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

namespace actions.CSP.CSPNavigationBar
{
    class CSPHoverOverAgents
    {
        public void run(Dictionary<string, object> Params)
        {
            var navigationBar = CSPBrowser.Application.WindowController.NavigationBar;
            navigationBar.Administration.Agents.Hover();
        }
    }
}