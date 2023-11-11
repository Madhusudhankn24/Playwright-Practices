package Assertionss;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import java.util.Collections;

public class PlaceHolderAssertions {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.facebook.com");
            Locator email_field = page.getByTestId("royal_email");
            /*
            Locator level Assertions
             */
            PlaywrightAssertions.assertThat(email_field)
                    .hasAttribute("placeholder","Email address or phone number");
        }
    }
}
