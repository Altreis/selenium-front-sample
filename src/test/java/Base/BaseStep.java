package Base;

import Environment.GlobalVariables;
import Xpath.Xpaths;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class BaseStep {
    public WebDriver driver;
    public Xpaths xpaths = new Xpaths();
    public GlobalVariables globalVariables = new GlobalVariables();

    private final static String MP = "MP";
    private final static String PP = "PP";
    private final static String SCP = "SCP";


    public void newUser(String userName, String password) throws Exception {
        clickElement("SignUpButton", MP);
        fillElement("SignUpUsername", MP, userName);
        fillElement("SignUpPassword", MP, password);
        clickElement("SignUpAccept", MP);
        alertAccept();
    }

    public void logInUser(String userName, String password) throws Exception {
        clickElement("LogInButton", MP);
        fillElement("LogInUsername", MP, userName);
        fillElement("LogInPassword", MP, password);
        clickElement("LogInpAccept", MP);
        alertAccept();
    }

    public void addToCart(String product, String category) throws Exception {
        clickElement(category, MP);
        clickElement(product, MP);
        clickElement("AddToCart", PP);
        alertAccept();
        goBack();
        goBack();
    }

    public void deleteFromCart(String value) throws Exception {
        xpaths.setDeleteButton(value);
        clickElement("Cart", MP);
        clickElement("DeleteButton", SCP);
        waitAsec();
    }

    public void checkName() throws Exception {
        xpaths.setNameText(globalVariables.getName());
        assertElement("Name", SCP, "Name: " + globalVariables.getName());
    }

    public void checkAmount(String amount) throws Exception {
        xpaths.setAmountText(amount);
        assertElement("AmountText", SCP, "Amount: " + amount + " USD");
        DriverQuit();
    }

    public BaseStep() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Enzu\\IdeaProjects\\Sample-Selenium-Project-With-Cucumber\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public void waitAsec() throws InterruptedException{
        Thread.sleep(2000);
    }

    public void goBack() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
    }

    public void alertAccept() throws InterruptedException {
        int i=0;
        while(i++<5)
        {
            try
            {
                driver.switchTo().alert().accept();
                break;
            }
            catch(NoAlertPresentException e)
            {
                Thread.sleep(1000);
                continue;
            }
        }
    }

    public void geturl() {
        driver.get("https://www.demoblaze.com/");
    }

    public void fillElement(String key, String list, String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, TimeOut.MIDDLE.value);
        switch (list) {
            case MP:
                wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpaths.getMainPage(key))))).sendKeys(value);
                break;
            case SCP:
                wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpaths.getShoppingCartPage(key))))).sendKeys(value);
                break;
            default:
                throw new Exception("The list '" + list + "' can't be found.");
        }
    }

    public void clickElement(String key, String list) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, TimeOut.MIDDLE.value);
        Exception exception = new Exception("The element '" + key + "' from the list '" + list + "' can't be clicked on the website.");
        switch (list) {
            case MP:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpaths.getMainPage(key))))).click();
                } catch (Exception e) {
                    throw new Exception(exception);
                }
                break;
            case PP:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpaths.getProductPage(key))))).click();
                } catch (Exception e) {
                    throw new Exception(exception);
                }
                break;
            case SCP:
                try {
                    wait.until(ExpectedConditions.elementToBeClickable((By.xpath(xpaths.getShoppingCartPage(key))))).click();
                } catch (Exception e) {
                    throw new Exception(exception);
                }
                break;
            default:
                throw new Exception("The list '" + list + "' can't be found.");
        }
    }

    public void assertElement(String key, String list, String textToCompare) throws Exception {
        Exception exception = new Exception("The element '" + key + "' from the list '" + list + "' can't be clicked on the website.");
        waitAsec();
        switch (list) {
            case SCP:
                assertTrue(exception.getMessage(), !driver.findElements(By.xpath(xpaths.getShoppingCartPage(key))).isEmpty());
                break;
            default:
                throw new Exception("The list '" + list + "' can't be found.");
        }
    }

    public void DriverQuit() {
        driver.quit();
    }

    public enum TimeOut {
        LOW(5),
        MIDDLE(10),
        HIGH(15),
        CUSTOM_MAX(60);
        private final int value;

        public int getValue() {
            return value;
        }

        private TimeOut(int value) {
            this.value = value;
        }
    }
}
