package CSPSSP;

import java.util.*;
import org.junit.Assert;

class ContainsText{
    public void run(HashMap<String, Object> params){
        
        if(!params.get("ExpectedText").toString().toLowerCase().contains(params.get("ActualText").toString().toLowerCase()))
            Assert.fail("The expected value doesn't contain the actual text");
        
    }
}