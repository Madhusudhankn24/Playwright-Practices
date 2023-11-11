package BrowserHandling;

import com.microsoft.playwright.*;

import java.util.Collections;

public class BrowserBackFaorword {
    public static void main(String[] args) {
        try(Playwright playwright=Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.facebook.com");
            Locator forgot_link = page.getByText("Forgotten password?");
            forgot_link.click();
            page.goBack();
            page.goForward();
        }
    }
}
