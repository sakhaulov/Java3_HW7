package sakhaulov.Atlassian;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AtlassianWebDriverListener implements WebDriverListener {

//    NOT USED ATM
//    goes into AbstractTest -> init()
//    WebDriverListener listener = new AtlassianWebDriverEventListener();
//    driver = new EventFiringDecorator(listener).decorate(original);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        System.out.println("ErrorErrorErrorErrorError");
    }

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Trying to click on element " + element.getTagName());
    }

    @Override
    public void afterClick(WebElement element) {
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Sending keys " + Arrays.toString(keysToSend) + " to element " + element.getTagName());
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Trying to find element with locator" + locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
        System.out.println("Trying to find elements with locator" + locator.toString());
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
    }

    @Override
    public void beforeTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Navigating to " + url);
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
    }

}
