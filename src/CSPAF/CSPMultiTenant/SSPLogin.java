package CSPAF.CSPMultiTenant;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.core.views.*;
import com.infor.cloudsuite.portal.multitenant.suites.controllers.*;


class SSPLogin
{
    public void run(HashMap<String, Object> params)
    {
        String loginInput = params.get("LoginInput").toString();
        CSPSSPAuthenticationController controller = new CSPSSPAuthenticationController();
        controller.login(loginInput);
    }
}