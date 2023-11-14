package Handling_Dailogs;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.Collections;

public class Handling_AlertsDailogs {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
            /*
            dialog handles the dialogsss.
             */
            page.onDialog(dialog -> {
                System.out.println(dialog.message());
                dialog.accept();
            });
            page.locator("text=Click for JS Alert").click();
        }
    }
}
