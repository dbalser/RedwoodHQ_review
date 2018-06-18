package CSPAF.CSPCore;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.infor.cloudsuite.portal.core.*;
import com.infor.cloudsuite.portal.core.controllers.*;
import com.infor.cloudsuite.portal.singletenant.gde.controllers.*;

class CSPGDELogin
{
    public void run(HashMap<String, Object> params)
    {
        String username = params.get("Username").toString();
        String password = params.get("Password").toString();
        CSPGDEAuthenticationController controller = new CSPGDEAuthenticationController();
        controller.login(username, password);
    }
}