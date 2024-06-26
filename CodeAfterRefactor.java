
public class CodeAfterRefactor {

	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.util.List;
	import java.util.concurrent.TimeUnit;


	    public static void main(String[] args) throws InterruptedException, AWTException {
	        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	        WebDriver driver = new FirefoxDriver();
	        try {                        //Code indentation done
	            driver.get("https://interview.supporthive.com/staff/");
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	            driver.manage().window().maximize();
	            login(driver);
	            forgotPassword(driver);     //Created assessable methods so that everyone can know which method belongs to which Functionality
	            verifyHomePage(driver);
	            navigateToStatuses(driver);
	            createNewStatus(driver);
	            makeStatusDefault(driver);
	            createPriority(driver);
	            deletePriority(driver);
	            logout(driver);
	        } finally {
	            driver.quit();
	        }
	    }
                                    //Removal of empty lines
	    public static void login(WebDriver driver) {
	        driver.findElement(By.id("id_username")).sendKeys("Agent");
	        driver.findElement(By.id("id_password")).sendKeys("Agent@123");
	        driver.findElement(By.id("btn-submit")).click();
	    }
	    
	    public void forgotPassword(webDriver driver) { //Usage of Camel cases for methods
            driver.findElement(By.linkText("Forgot password?")).click();
        }
        
	    public void verifyHomePage(WebDriver driver) {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
            
            public void navigateToProfile(webDriver driver) {
                driver.findElement(By.id("profileLink")).click();
            }
        }
            
	    public static void navigateToStatuses(WebDriver driver) {
	    	WebElement tickets;
	        tickets = driver.findElement(By.id("ember29"));
	        Actions action = new Actions(driver);
	        action.moveToElement(tickets).build().perform();
	        driver.findElement(By.linkText("Statuses")).click();
	    }

	    public static void createNewStatus(WebDriver driver) throws AWTException {
	    	WebElement statusColourSelect;
	        WebElement statusColourEnter;      // Variable declaration at the Top 
	        WebElement addCreate;
	        driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();
	        driver.findElement(By.tagName("input")).sendKeys("Issue Created");
	        statusColourSelect = driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
	        statusColourSelect.click();
	        statusColourEnter = driver.findElement(By.xpath("//input[@class='sp-input']"));
	        statusColourEnter.clear();
	        statusColourEnter.sendKeys("#47963f");
	        Robot r = new Robot();
	        r.keyPress(KeyEvent.VK_ESCAPE);
	        driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
	        addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
	        addCreate.click();
	    }

	    public static void makeStatusDefault(WebDriver driver) throws InterruptedException {
	    	WebElement moveTo;
	    	WebElement issue;
	    	WebElement make;
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	        moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
	        Actions action = new Actions(driver);
	        action.moveToElement(moveTo).build().perform();
	        moveTo.click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Issue Created')]")));
	        issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
	        action.moveToElement(issue).build().perform();
	        make = driver.findElement(By.linkText("Make Default"));
	        make.click();
	    }

	    public static void createPriority(WebDriver driver) throws InterruptedException {
	    	WebElement button;
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	        driver.findElement(By.linkText("Priorities")).click();
	        driver.findElement(By.xpath("//header/button[1]")).click();
	        driver.findElement(By.tagName("input")).sendKeys("Assistance required");
	        driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
	        button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
	        button.click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ember29")));
	    }

	    public static void deletePriority(WebDriver driver) throws InterruptedException {
	    	String frequentXpath = "/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]"
	        WebElement tickets;          
	    	WebElement priorities;
	    	WebElement delete;
	    	WebDriverWait wait = new WebDriverWait(driver, 10);
	    	tickets = driver.findElement(By.id("ember29"));
	        Actions action = new Actions(driver);
	        action.moveToElement(tickets).build().perform();
	        priorities = driver.findElement(By.linkText("Priorities"));
	        priorities.click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(frequentXpath))); //Common variable to store xpaths used in many places.
	        driver.findElement(By.xpath(frequentXpath).click();
	        driver.findElement(By.linkText("Delete")).click();
	        delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
	        delete.click();
	    }

	    public static void logout(WebDriver driver) {
	        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();
	        driver.findElement(By.linkText("Logout")).click();
	    }
	}
