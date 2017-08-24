package CSPSSP;

import java.util.*;
import org.junit.Assert;

class CompareLists{
    public void run(HashMap<String, List<String>> params){
        Assert.assertEquals(params.get("ExpectedList").toArray(new String[0]),params.get("ActualList").toArray(new String[0]));
    }
}