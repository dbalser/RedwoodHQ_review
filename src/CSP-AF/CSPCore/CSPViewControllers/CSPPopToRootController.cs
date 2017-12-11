using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

class CSPPopToRootController
{
    public void run(Dictionary<string, object> Params) {
        CSPBrowser.Application.WindowController.NavigationController.PopToRootViewController();
    }
}