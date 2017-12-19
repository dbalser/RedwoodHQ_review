package CSPAF.CSPCore;

import java.util.*;

import com.infor.cloudsuite.portal.core.views.*;
import com.infor.cloudsuite.portal.core.helpers.*;
import com.infor.cloudsuite.portal.core.services.*;
import com.infor.cloudsuite.portal.core.controllers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

class CSPSearchValue
{
    private CSPTable table = null;
    private CSPInput searchInput = null;
    private CSPButton searchButton = null;
        
    public void run(HashMap<String, Object> params)
    {
        String tableId = params.get("Table Id").toString();
        String columnId = params.get("Column Id").toString();
        String inputId = params.get("Search Input Id").toString();
        String searchValue = params.get("Search Value").toString();
        String buttonId = params.get("Search Button Id").toString();
        int rowIndex = Integer.parseInt(params.get("Row Index").toString());
            
        this.prepare(inputId, buttonId, tableId);
        
        this.searchInput.setValue(searchValue);
        this.searchButton.click();
            
        List<CSPTableRow> rows = (List<CSPTableRow>)this.table.getRows();
        WebElement columnElement = rows.get(rowIndex).webElementForColumn(columnId);
            
        WebDriverWait wait = new WebDriverWait(CSPBrowser.getApplication().getWebDriver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(columnElement, searchValue));
            
        this.cleanUp();
    }
        
    public void prepare(String inputId, String buttonId, String tableId)
    {
        CSPNavigationController navigationController = CSPBrowser.getApplication().getWindowController().getNavigationController();
        CSPViewController visibleViewController = navigationController.getVisibleViewController();
            
        this.searchInput = new CSPInput(null, inputId);
        visibleViewController.getView().addSubview(this.searchInput);
    
        this.searchButton = new CSPButton(null, buttonId);
        visibleViewController.getView().addSubview(this.searchButton);
            
        this.table = new CSPTable(null, tableId);
        visibleViewController.getView().addSubview(this.table);
    }
        
    public void cleanUp()
    {
        this.searchInput.removeFromSuperview();
        this.searchButton.removeFromSuperview();
        this.table.removeFromSuperview();
    }
}