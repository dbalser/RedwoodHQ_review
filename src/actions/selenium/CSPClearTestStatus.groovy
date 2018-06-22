package actions.selenium;
import groovy.io.FileType

class CSPClearTestStatus{
    public Boolean run(def params){
//   		def tempDir = System.getenv("TEMP")
//        def basePath = tempDir + "//CSPAutomation"
        def basePath = "D:\\Applications\\RedwoodHQ\\logs" + "//CSPAutomation"

        for (thisFolder in ['//PASSED','//FAILED']) {
			String thisPath = basePath + thisFolder
	 		new File(thisPath).mkdirs()
            for(File file: (new File (thisPath)).listFiles()){
                file.delete();
            }
        }
		File ldd = new File(basePath + '//' + 'lastDependencyDate' )
        ldd.text = "0"   
		File led = new File(basePath + '//' + 'lastEndDate' )
        led.text = "0"   
    }
}