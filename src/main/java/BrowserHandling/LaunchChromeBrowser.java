package BrowserHandling;

import com.microsoft.playwright.*;

public class LaunchChromeBrowser {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setChannel("chrome"));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
        }
    }
}
