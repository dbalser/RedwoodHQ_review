package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPGDEProdTypeDeploymentLaunch{
    public void run(HashMap<String, Object> params){
        String deploymentNameInput = params.get("Deployment").toString();
        String aliasInput = params.get("AliasName").toString();
        String environmentTypeDropdown=params.get("Type").toString();
        String amazonCredentialsDropdown = params.get("AmazonCredentials").toString();
        String productDropdown = params.get("Product").toString();
        String versionDropdown = params.get("Version").toString();
        String awsRegionDropdown = params.get("AwsRegion").toString();
        String awsAvailabilityZoneDropdown = params.get("AwsAvailabilityZone").toString();
        String liltimValue = params.get("Liltim URL Value").toString();
        String stopAtHoursDropdown = params.get("StopAtHours").toString();
        String timeZoneDropdown = params.get("TimeZone").toString();
        String backupDropdown = params.get("Backup Option").toString();


        CSPGDEProdTypeDeploymentLaunchController controller =new CSPGDEProdTypeDeploymentLaunchController();
        controller.productionDeploymentLaunch(deploymentNameInput,aliasInput,environmentTypeDropdown,amazonCredentialsDropdown,productDropdown,versionDropdown,awsRegionDropdown,awsAvailabilityZoneDropdown,liltimValue,stopAtHoursDropdown,timeZoneDropdown,backupDropdown);        
    }
}