package actions.selenium;
import redwood.launcher.*

class CSPTestPassed{
    public void run(def params){
        def thisTestCase = redwood.launcher.Launcher.globals.get("testcaseName")
		def tempDir = System.getenv("TEMP")
        def basePath = tempDir + "//CSPAutomation"
		def thisPath = basePath + '//PASSED//' + thisTestCase
        new File(thisPath).mkdirs()
        long now = System.currentTimeMillis()
        System.out.println("Test Passed" + " now=" + now)
    }
}