package CSPSSP;

import java.util.*;

class UploadFile{
    public void run(HashMap<String, Object> params) {
        
        try{
        Runtime.getRuntime().exec("uploadinfor_image.exe");
        }
        catch(Exception e)
        {
            System.out.println("File upload failed: "+e.getMessage());
        }
    }
}