using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

namespace actions.CSP
{
    class CSPCloseBrowser
    {
        public void run(Dictionary<string, object> Params)
        {
            try
            {
            	CSPBrowser.Application.WebDriver.Close();
            	CSPBrowser.Application.WebDriver.Quit();
            }
            catch {}
        }
    }
}