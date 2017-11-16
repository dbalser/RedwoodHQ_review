package actions.selenium;
import redwood.launcher.*

class CSPSetPassFail{
    public void run(def params){
        def thisTestCase = redwood.launcher.Launcher.globals.get("testcaseName")
   		def tempDir = System.getenv("TEMP")
        def basePath = tempDir + "//CSPAutomation"
		def successPath = basePath + '//PASSED//' + thisTestCase
		def failPath = basePath + '//FAILED//' + thisTestCase

        long now = System.currentTimeMillis()
        File led = new File(basePath + '//' + 'lastEndDate' )
        led.text = now
        System.out.println("Set Pass Fail" + " now=" + now)
//look into invoking SetPassFail before closing browser.
//        long lastDependencyDate = Long.parseLong(ldd.text)
//        def endInterval = 15


//        System.out.println(successPath)
//        System.out.println(new File(successPath).isDirectory())
        if (new File(successPath).isDirectory()) {
           return 
        }

        new File(failPath).mkdirs()   
    }
}