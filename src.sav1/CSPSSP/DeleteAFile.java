package CSPSSP;
import java.io.File;
import java.util.*;

class DeleteAFile{
    public void run(HashMap<String, Object> params){
        String fileName = params.get("FileName").toString();
       String home = System.getProperty("user.home");
		File f = new File(home+"\\Downloads\\"+fileName); 
        f.delete();
    }
}