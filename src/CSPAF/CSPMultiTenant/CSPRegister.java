package CSPAF.CSPMultiTenant;

import java.util.*;
import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.multitenant.controllers.*;
class CSPRegister
{
    public void run(HashMap<String, Object> params)
    {
        String email = params.get("email").toString();
        String firstName = params.get("firstName").toString();
        String lastName = params.get("lastName").toString();
        String companyName = params.get("companyName").toString();
        String address1 = params.get("address1").toString();
        String address2 = params.get("address2").toString();
        String phoneNumber = params.get("phoneNumber").toString();
        String country = params.get("country").toString();
        CSPAccountRegistrationController controller = new CSPAccountRegistrationController();
        controller.register(email, firstName,lastName,companyName,address1,address2,phoneNumber,country);
    }
}