package CSPSSP;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys


class MatchRecipientsInCategory{
    public void run(HashMap<String, Object> params){
        if(params.get("options").toString().equals("Sent")){
            def elements = Elements.findAll(params,Browser.Driver)            
            if(elements.size() == Integer.parseInt(params.get("requiredSize"))){
                for(int i=0; i<elements.size(); i++){
                    if(!(elements[i].getText()).equals(params.requiredText[i])){
                         assert elements[i].getText() == params.requiredText[i], "Error expected text: ${elements[i].getText()} does not match text on the UI: ${params.requiredText[i]}"
                	}
                }
            }
        }        
	}
}