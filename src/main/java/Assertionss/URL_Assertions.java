package Assertionss;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import java.util.Collections;

public class URL_Assertions {
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
            /*
            Page level Assertions
             */
            PlaywrightAssertions.assertThat(page)
                    .hasURL("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");

        }
    }
}
