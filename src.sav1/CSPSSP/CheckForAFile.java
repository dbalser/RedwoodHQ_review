package CSPSSP;
import java.io.File;
import java.util.*;
import org.junit.Assert;

class CheckForAFile{
    public void run(HashMap<String, Object> params){
        
         String fileName = params.get("FileName").toString();
       String home = System.getProperty("user.home");
		File f = new File(home+"\\Downloads\\"+fileName);    
        Assert.assertEquals(true, f.isFile());
    }
}