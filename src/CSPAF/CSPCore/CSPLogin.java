package CSPAF.CSPCore;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.core.controllers.*;

class CSPLogin
{
    public void run(HashMap<String, Object> params)
    {
        String username = params.get("Username").toString();
        String password = params.get("Password").toString();
        CSPAuthenticationController controller = new CSPAuthenticationController();
        controller.login(username, password);
    }
}