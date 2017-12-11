using System;
using System.Reflection;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

public class CSPPushController
{
    public void run(Dictionary<string, object> Params)
    {
        var className = "CloudSuitePortal.Controllers." + (string)Params["Class Name"] + ", CloudSuitePortal";
        var controllerType = Type.GetType(className);

        if (controllerType == null) {
            throw new System.TypeLoadException(className + " is not valid.");
        }

        var controller = (CSPViewController)Activator.CreateInstance(controllerType, null);
        CSPBrowser.Application.WindowController.NavigationController.Push(controller);
    }
}