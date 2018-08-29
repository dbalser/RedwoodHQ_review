package CSPAF.CSPMultiTenant;
import com.infor.cloudsuite.portal.multitenant.environments.controllers.*;

import com.infor.cloudsuite.portal.core.controllers.CSPViewController;
import com.infor.cloudsuite.portal.core.mongoose.CSPMongooseConstants;
import com.infor.cloudsuite.portal.core.views.CSPButton;
import com.infor.cloudsuite.portal.core.views.CSPInput;

import java.util.*;

class CSPCreateCustomer{
    public void run(HashMap<String, Object> params){
      String customer = params.get("Customer").toString();

      CSPCreateCustomerController controller=new CSPCreateCustomerController();
      controller.createCustomer(customer);
    }
}