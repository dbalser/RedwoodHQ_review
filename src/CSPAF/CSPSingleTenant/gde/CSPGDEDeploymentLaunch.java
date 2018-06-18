package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPGDEDeploymentLaunch{
    public void run(HashMap<String, Object> params){
        String deploymentNameInput = params.get("DeploymentName").toString();
        String aliasInput = params.get("AliasName").toString();
        String amazonCredentialsDropdown = params.get("AmazonCredentials").toString();
        String productDropdown = params.get("Product").toString();
        String versionDropdown = params.get("Version").toString();
        String awsRegionDropdown = params.get("AwsRegion").toString();
        String awsAvailabilityZoneDropdown = params.get("AwsAvailabilityZone").toString();
        String stopAtHoursDropdown = params.get("StopAtHours").toString();
        String timeZoneDropdown = params.get("TimeZone").toString();

        CSPGDEDemoDeploymentLaunchController controller =new CSPGDEDemoDeploymentLaunchController();
        controller.deploymentLaunch(deploymentNameInput,aliasInput,amazonCredentialsDropdown,productDropdown,versionDropdown,awsRegionDropdown,awsAvailabilityZoneDropdown,stopAtHoursDropdown,timeZoneDropdown);        
    }
}