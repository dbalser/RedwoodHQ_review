using System;
using System.Collections.Generic;

using CloudSuitePortal;
using CloudSuitePortal.Views;
using CloudSuitePortal.Services;

using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;

namespace actions.CSP
{
    class CSPSearchValue
    {
        private CSPTable Table { get; set; }
        private CSPInput SearchInput { get; set; }
        private CSPButton SearchButton { get; set; }
        
        public void run(Dictionary<string, object> Params)
        {
            var tableId = (string)Params["Table Id"];
            var columnId = (string)Params["Column Id"];
            var inputId = (string)Params["Search Input Id"];
            var searchValue = (string)Params["Search Value"];
            var buttonId = (string)Params["Search Button Id"];
            var rowIndex = Int32.Parse((string)Params["Row Index"]);
            
            this.Prepare(inputId, buttonId, tableId);
            
            this.SearchInput.SetValue(searchValue);
            this.SearchButton.Click();
            
            var rows = (List<CSPTableRow>)this.Table.Rows;
            var columnElement = rows[rowIndex].WebElementForColumn(columnId);
            
            var wait = new WebDriverWait(CSPBrowser.Application.WebDriver, TimeSpan.FromSeconds(30));
            wait.Until(ExpectedConditions.TextToBePresentInElement(columnElement, searchValue));
            
            this.CleanUp();
        }
        
        public void Prepare(string inputId, string buttonId, string tableId)
        {
            var navigationController = CSPBrowser.Application.WindowController.NavigationController;
            var visibleViewController = navigationController.VisibleViewController;
            
            this.SearchInput = new CSPInput(null, inputId);
            visibleViewController.View.AddSubview(this.SearchInput);
            
            this.SearchButton = new CSPButton(null, buttonId);
            visibleViewController.View.AddSubview(this.SearchButton);
            
            this.Table = new CSPTable(null, tableId);
            visibleViewController.View.AddSubview(this.Table);
        }
        
        public void CleanUp()
        {
            this.SearchInput.RemoveFromSuperview();
            this.SearchButton.RemoveFromSuperview();
            this.Table.RemoveFromSuperview();
        }
    }
}