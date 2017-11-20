package actions.selenium;
import groovy.io.FileType
import redwood.launcher.*
import groovy.time.*
//Test Comment
class CSPThisTestDependsOn{
    public void run(def params){
        def testNameArray = params."TestName"
        System.out.println("Starting 'ThisTestDependsOn'")

        if (testNameArray.isEmpty()) {
            return
        } 
        def thisTestCase = redwood.launcher.Launcher.globals.get("testcaseName")
        def tempDir = System.getenv("TEMP")
        def basePath = tempDir + "//CSPAutomation"
		File ldd = new File(basePath + '//' + 'lastDependencyDate' )
		File led = new File(basePath + '//' + 'lastEndDate' )
                
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
	    	long lastDependencyDate = Long.parseLong("0"+ldd.text)
	    	long lastEndDate = Long.parseLong("0"+led.text)

			long timeSinceLastDependency = (now - lastDependencyDate )/1000
			long timeSinceLastEnd = (now - lastEndDate )/1000
            def endInterval = 40
			def interval = 130
            if (thisTestCase == 'MT_REG_01_Ming.le_ManualProvisioning'){
                interval = 70;
            }
            if ((timeSinceLastDependency >= interval) &&
                (timeSinceLastEnd >= endInterval) &&
                allPassed) { //allow no more than one test per 60 seconds to launch
                ldd.text = now   
	            System.out.println("End wait for " + thisTestCase + " ldd=" + lastDependencyDate + " led=" + lastEndDate + " now=" + now)
                return
            }

            def myRand = Math.abs(new Random().nextInt() % 999) + 1
            sleep(12000 + myRand) 
        }
    }
}

