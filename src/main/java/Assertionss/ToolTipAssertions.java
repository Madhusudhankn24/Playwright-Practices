package Assertionss;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.Collections;

public class ToolTipAssertions {
    public static void main(String[] args) throws InterruptedException {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://jqueryui.com/tooltip/");
            Thread.sleep(2000);
            page.locator("[id='age']").hover();
//            String tooltip = textfield.textContent();
//            System.out.println(tooltip);
        }
    }
}
