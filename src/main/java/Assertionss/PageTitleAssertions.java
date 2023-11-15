package Assertionss;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import java.util.Collections;

public class PageTitleAssertions {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://jqueryui.com/tooltip/");
            Locator Draggable_link = page.getByText("Draggable");
            Draggable_link.click();
            PlaywrightAssertions.assertThat(page).hasTitle("Draggable | jQuery UI");
        }
    }
}
