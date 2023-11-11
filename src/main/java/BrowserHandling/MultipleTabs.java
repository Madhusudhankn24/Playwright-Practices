package BrowserHandling;

import com.microsoft.playwright.*;

import java.util.Collections;

public class MultipleTabs {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context1 = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            BrowserContext context2 = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));
            Page page1 = context1.newPage();
            page1.navigate("https://facebook.com");
            Page page2 = context1.newPage();
            page2.navigate("https://www.youtube.com");
        }
    }
}

