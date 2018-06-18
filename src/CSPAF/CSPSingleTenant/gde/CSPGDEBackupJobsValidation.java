package CSPAF.CSPSingleTenant.gde;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPGDEBackupJobsValidation{
    public void run(HashMap<String, Object> params){
       
        CSPBackupJobsController controller = new CSPBackupJobsController();
        controller.backupJobVerify();
    }
}