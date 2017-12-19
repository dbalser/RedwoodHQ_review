package CSPAF.CSPAgents;

import java.io.*;
import java.util.*;

import com.infor.cloudsuite.portal.singletenant.agents.services.*;

class CSPGetAgentGUID
{
    public String run(HashMap<String, Object> params) throws IOException {
        return CSPAgentService.fetchGUID();
    }
}