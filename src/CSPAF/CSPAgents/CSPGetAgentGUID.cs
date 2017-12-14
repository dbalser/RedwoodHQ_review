using System;
using System.Collections.Generic;

using CloudSuitePortal.Services;

namespace CSPAF.CSPAgents
{
    class CSPGetAgentGUID
    {
        public string run(Dictionary<string, object> Params) {
            return CSPAgentService.GUID;
        }
    }
}