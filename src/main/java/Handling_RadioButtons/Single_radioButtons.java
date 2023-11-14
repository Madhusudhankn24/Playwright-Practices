package Handling_RadioButtons;

import com.microsoft.playwright.*;

import java.util.Collections;

public class Single_radioButtons {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://dev.automationtesting.in/form");
            page.check("[value='Female']");
        }
    }
}
