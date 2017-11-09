package actions.selenium;
import groovy.io.FileType
import redwood.launcher.*
import groovy.time.*

class CSPThisTestDependsOn{
//    static public long lastDependencyDate = System.currentTimeMillis(); //
    static public long lastDependencyDate = 0; //

    public void run(def params){
        def testNameArray = params."TestName"
        if (testNameArray.isEmpty()) {
            return
        } 
        def thisTestCase = redwood.launcher.Launcher.globals.get("testcaseName")
        def tempDir = System.getenv("TEMP")
        def basePath = tempDir + "//CSPAutomation"
                
        while (true) {
            def allPassed = true
            testNameArray.each {
                String checkThisDependency = "${it}"
                def successPath = basePath + '//PASSED//' + checkThisDependency
                def failPath = basePath + '//FAILED//' + checkThisDependency
                if (new File(failPath).isDirectory()) {
                    assert false , thisTestCase + " Failed because it depends on ${checkThisDependency} which failed"               
                }
                if (!(new File(successPath).isDirectory())) {
                    allPassed = false
                }
            }
			long now = System.currentTimeMillis()
			long timeSinceLastDependency = (now - lastDependencyDate )/1000
            if ((timeSinceLastDependency >= 60) && allPassed) { //allow no more than one test per 60 seconds to launch
				lastDependencyDate = now
                return
            }
            def myRand = Math.abs(new Random().nextInt() % 999) + 1
            sleep(15000 + myRand) 
        }
    }
}

