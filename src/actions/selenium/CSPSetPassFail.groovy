package actions.selenium;
import redwood.launcher.*

class CSPSetPassFail{
    public void run(def params){
        def thisTestCase = redwood.launcher.Launcher.globals.get("testcaseName")
   		def tempDir = System.getenv("TEMP")
        def basePath = tempDir + "//CSPAutomation"
		def successPath = basePath + '//PASSED//' + thisTestCase
		def failPath = basePath + '//FAILED//' + thisTestCase

        System.out.println(successPath)
        System.out.println(new File(successPath).isDirectory())
        if (new File(successPath).isDirectory()) {
           return 
        }

        new File(failPath).mkdirs()   
    }
}