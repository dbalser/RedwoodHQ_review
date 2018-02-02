package CSPAF.CSPSingleTenant.gde;

import java.util.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.singletenant.gde.models.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class GDERegister
{
    public void run(HashMap<String, Object> params)
    {
        CSPGDERegistration registration = new CSPGDERegistration();
        registration.email = params.get("email").toString();
        registration.firstName = params.get("firstName").toString();
        registration.lastName = params.get("lastName").toString();
        registration.companyName = params.get("companyName").toString();
        registration.address1 = params.get("address1").toString();
        registration.address2 = params.get("address2").toString();
        registration.phoneNumber = params.get("phoneNumber").toString();
        registration.country = params.get("country").toString();
        
        CSPGDEAccountRegistrationController controller = new CSPGDEAccountRegistrationController();
        controller.register(registration);
    }
}