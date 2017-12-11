using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

class CSPOpenBrowser
{
    public void run(Dictionary<string, object> Params) 
    {
        var url = (string)Params["URL"];
        var browserType = (string)Params["Browser Type"];
        CSPBrowser.GoToURL(url, browserType);
    }
}