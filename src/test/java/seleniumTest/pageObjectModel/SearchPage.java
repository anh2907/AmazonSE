package seleniumTest.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    private By searchDropdownBox = By.xpath(".//select[@id='searchDropdownBox']");
    private By searchInput = By.xpath(".//input[@id='twotabsearchtextbox']");
    private By bookElement = By.xpath(".//option[contains(text(),'Books')]");
    private By searchIcon = By.xpath(".//input[@type='submit' and @class='nav-input']");
    private By searchBookLanguage = By.xpath(".//span[contains(text(),'English')]/preceding-sibling::div/label/input");
    private By searchList = By.xpath(".//div[@class='s-main-slot s-result-list s-search-results sg-row']");
    private By resultList = By.xpath(".//div[@data-asin!='' and @data-index]");
    private By nextButton = By.xpath(".//li[@class='a-last']");
    private By sortList = By.xpath(".//select[@id='s-result-sort-select']");
    private By selectedSortItem = By.xpath(".//select[@id='s-result-sort-select']//option[@selected]");
    private By optionPriceLowToHigh = By.xpath(".//a[contains(text(),'Price: Low to High')]");

    public void performSearch(String keyword) throws InterruptedException {
        clickSearchDropdownBox();
        clickBookElement();
        setSearchInput(keyword);
        clickSearchIcon();
        clickSearchBookLanguage();
    }
    public void clickSearchDropdownBox(){
        driver.findElement(searchDropdownBox).click();
    }
    public void clickBookElement(){
        driver.findElement(bookElement).click();
    }
    public void setSearchInput(String keyword){
        driver.findElement(searchInput).sendKeys(keyword);
    }
    public void clickSearchIcon(){
        driver.findElement(searchIcon).click();
    }
    public void clickNextButton(){
        if(driver.findElement(nextButton).isEnabled())
        {
            driver.findElement(nextButton).click();
        }
        else{
            System.out.println("Next button is not enabled");
        }

    }
    public void clickSearchBookLanguage(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBookLanguage));
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(searchBookLanguage);
        actions.moveToElement(element).click().perform();

    }
    public int getResultList(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchList));
        WebElement list = driver.findElement(searchList);
        List<WebElement> results = list.findElements(resultList);
        return results.size();
    }

    public void clickSortList(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(sortList);
        actions.moveToElement(element).click().perform();
    }
    public void clickOptionPriceLowToHigh(){
        if(driver.findElement(optionPriceLowToHigh).isEnabled())
        {
            driver.findElement(optionPriceLowToHigh).click();
        }
        else{
            System.out.println("Selected option is not enabled");
        }
    }
    public String getSelectedSortItem(){
        String s = driver.findElement(selectedSortItem).getText();
        return s;
    }
}
