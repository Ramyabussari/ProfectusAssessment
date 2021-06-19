package Pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinSendMessage extends PageObject {
    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElementFacade nameInputBox;

    @FindBy(linkText = "Message")
    private WebElementFacade messageButton;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElementFacade messageInputBox;

    @FindBy(xpath = "//button[text()='Send']")
    private WebElementFacade sendButton;

    @FindBy(xpath = "//input[@id='session_key']")
    private WebElementFacade userNameInput;

    @FindBy(xpath = "//input[@id='session_password']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElementFacade signIn;

    @FindBy(xpath = "//button[contains(text(),'Not now')]")
    private WebElementFacade NotNow;

    @FindBy(xpath = "//h3[contains(text(),'Remember me on this browser')]")
    private WebElementFacade rememberMe;

    @FindBy(xpath = "//*[starts-with(@id,'basic-result')]/div/span/span[1]/strong")
    private WebElementFacade selectProfile;

    @FindBy(xpath = "//span[text()='Me']")
    private WebElementFacade mebutton;

    @FindBy(xpath = "//button[@data-control-name='overlay.close_conversation_window']/li-icon")
    private WebElementFacade closeMessageBox;

    public void launchUI() {
        try {

            getDriver().get("https://www.linkedin.com");
        } catch (Exception e) {
            Assert.fail("Unable to launch url");
        }
    }

    public void searchForProfile(String name) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(ExpectedConditions.urlContains("feed"));
            nameInputBox.click();
            nameInputBox.sendKeys(name);
            wait.until(ExpectedConditions.visibilityOf(selectProfile));
            selectProfile.click();

        } catch (Exception e) {
            Assert.fail("Search for a name failed");
        }
    }

    public void validateProfilePage(String expectedName) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
            wait.until(ExpectedConditions.urlContains(expectedName));
            Assert.assertTrue(getDriver().getCurrentUrl().contains(expectedName));
        } catch (Exception e) {
            Assert.fail("Not on Profile page");
        }
    }

    public void clickOnButton(String button) {
        try {
            if (button.equalsIgnoreCase("Message")) {
                messageButton.click();
            } else if (button.equalsIgnoreCase("Send")) {
                sendButton.click();

            } else if (button.equalsIgnoreCase("Me")) {
                mebutton.click();

            } else if (button.equalsIgnoreCase("Sign in")) {
                signIn.click();
            } else if (button.equalsIgnoreCase("logout")) {
                findAll("//ul[@class='global-nav__secondary-items']/li");
                for (WebElement element : findAll("//ul[@class='global-nav__secondary-items']/li")) {
                    if (element.getText().equalsIgnoreCase("Sign Out")) {
                        element.click();
                        break;

                    }
                }
            } else if (button.equalsIgnoreCase("Close message box")) {
                closeMessageBox.click();
            }

        } catch (Exception e) {
            Assert.fail("Click on button failed");
        }
    }

    public void sendTextMessage(String message) {
        try {
            messageInputBox.sendKeys(message);
        } catch (Exception e) {
            Assert.fail("Send keys failed");
        }
    }


    //These credentials can be also passed from serenity.config file
    public void enterCredentials() {
        try {

            String username = "XXXX";
            String password = "XXXX";
            userNameInput.sendKeys(username);
            passwordInput.sendKeys(password);
            signIn.click();
            if (rememberMe.isVisible()) {
                NotNow.click();
            }

        } catch (Exception e) {
            Assert.fail("Invaild Credentials");
        }
    }
}
