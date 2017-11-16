package CSPSSP;

import actions.selenium.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
import org.junit.Assert;


class VerifyNotification{
    public String run(HashMap<String, Object> params){
        WebElement element= null;
        List<WebElement> table=null;
        String str=params.get("Text").toString();
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
        if(params.get("Category").toString().equals("Sent")){
            element = Browser.Driver.findElement(By.xpath(".//span[@data-mgcompnamevalue='notebookTabSent']")); 
            element.click();
            
            table = Browser.Driver.findElements(By.xpath("//div[@data-mgcompname='SentGrid']/div/div/div/div[2]/div[2]/div/div[2]/table"));  
            if(table.size()!=Integer.parseInt(params.get("Count").toString()))
                Assert.fail("Count on UI with number of emails passed not matching");
            if(str!=""){
                for(int j=0;j<table.size();j++){
                    for(int i=1;i<2;i++){
                        String txt=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='SentGrid']/div/div/div/div[2]/div[2]/div/div[2]/table["+(j+1)+"]/tbody/tr/td["+i+"]/div")).getText();
                        if(txt.equals(items.get(j).toString()))
                        {
                            return "Matched";
                        }
                        else
                            Assert.fail("Email id "+items.get(j).toString()+" not found on UI");

                    }
                }
            }
        }
        else if(params.get("Category").toString().equals("Bounced")){
            element = Browser.Driver.findElement(By.xpath(".//span[@data-mgcompnamevalue='notebookTabBounced']"));
            element.click();
            
            table = Browser.Driver.findElements(By.xpath("//div[@data-mgcompname='BouncedGrid']/div/div/div/div[2]/div[2]/div/div[2]/table"));  
            if(table.size()!=Integer.parseInt(params.get("Count").toString()))
                Assert.fail("Count on UI with number of emails passed not matching");
            if(str!=""){
                for(int j=0;j<table.size();j++){
                    for(int i=1;i<2;i++){
                        String txt=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='BouncedGrid']/div/div/div/div[2]/div[2]/div/div[2]/table["+(j+1)+"]/tbody/tr/td["+i+"]/div")).getText();
                        if(txt.equals(items.get(j).toString()))
                        {
                            return "Matched";
                        }
                        else
                            Assert.fail("Email id "+items.get(j).toString()+" not found on UI");

                    }
                }
        	}
        }
        else if (params.get("Category").toString().equals("Not Sent")){
            element = Browser.Driver.findElement(By.xpath(".//span[@data-mgcompnamevalue='notebookTabNotSent']")); 
            element.click();
            
            table = Browser.Driver.findElements(By.xpath("//div[@data-mgcompname='NotSentGrid']/div/div/div/div[2]/div[2]/div/div[2]/table"));  
            if(table.size()!=Integer.parseInt(params.get("Count").toString()))
                Assert.fail("Count on UI with number of emails passed not matching");
            if(str!=""){
                for(int j=0;j<table.size();j++){
                    for(int i=1;i<2;i++){
                        String txt=Browser.Driver.findElement(By.xpath("//div[@data-mgcompname='NotSentGrid']/div/div/div/div[2]/div[2]/div/div[2]/table["+(j+1)+"]/tbody/tr/td["+i+"]/div")).getText();
                        if(txt.equals(items.get(j).toString()))
                        {
                            return "Matched";
                        }
                        else
                            Assert.fail("Email id "+items.get(j).toString()+" not found on UI");

                    }
                }
        	}
        }
        
        
        else
            return "Invalid category";
        
        return "Not found";
        
    }
}