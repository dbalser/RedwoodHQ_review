package CSPAF;

import java.io.*;
import java.util.*;

import com.infor.cloudsuite.portal.core.services.CSPCommandLineInterpreter;


class CreateAdminCMD
{
    public void run(HashMap<String, Object> params) throws IOException
    {
        CSPCommandLineInterpreter cmd = new CSPCommandLineInterpreter();
        cmd.createBat();
    }
}