using System;
using System.Linq;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Services;

namespace actions.CSP
{
    class CSPGetObjectId
    {
        public string run(Dictionary<string, object> Params)
        {
            string prefix = (string)Params["Prefix"];
            string function = (string)Params["Function"];
            string fileName = (string)Params["File Name"];
            string filePath = CSPLogger.ProjectDirectoryPath() + "\\" + fileName;
            
            var validFunctions = new string[] {"get", "increment"};
            if (!validFunctions.Contains(function.ToLower())) { return null; }

            var objectId = prefix;
            var logger = new CSPLogger(filePath);
            var id = logger.NumberOfLines();

            if (function.ToLower() == "get") { id -= 1; }

            return objectId + id;
        }
    }
}