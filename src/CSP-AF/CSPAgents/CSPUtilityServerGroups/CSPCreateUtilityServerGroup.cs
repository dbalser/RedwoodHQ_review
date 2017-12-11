using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Models;
using CloudSuitePortal.Services;
using CloudSuitePortal.Controllers;

namespace actions.CSP.CSPAgents.CSPUtilityServerGroups
{
    class CreateUtilityServerGroup
    {
        public void run(Dictionary<string, object> Params)
        {
            var name = (string)Params["Name"];
            var region = (string)Params["Region"];
            var description = (string)Params["Description"];
            var amazonCredentials = (string)Params["Amazon Credentials"];
            
            var utilityServerGroup = new CSPUtilityServerGroup();
            utilityServerGroup.Name = name;
            utilityServerGroup.Region = region;
            utilityServerGroup.Description = description;
            utilityServerGroup.AmazonCredentials = amazonCredentials;
            
            var navigationController = CSPBrowser.Application.WindowController.NavigationController;
            var controller = (CSPUtilityServerGroupsController)navigationController.VisibleViewController;
            controller.Create(utilityServerGroup);
        }
    }
}