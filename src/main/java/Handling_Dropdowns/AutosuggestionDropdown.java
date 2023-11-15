package Handling_Dropdowns;

import com.microsoft.playwright.*;

import java.util.Collections;
import java.util.List;

public class AutosuggestionDropdown {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.redbus.in/");
            Locator autosuggestion_DB = page.locator("#src");
            autosuggestion_DB.fill("Banglore");
            /*
            wait for suggestions to be appear after that
            locates the options and selects one
             */
            page.waitForSelector("//li[contains(@class,'sc-iwsKbI')]/div/text[1]");
            List<ElementHandle> options = page.locator("//li[contains(@class,'sc-iwsKbI')]/div/text[1]").elementHandles();
            for (ElementHandle option : options) {
                String cityName = option.innerText();
                System.out.println("City Name: " + cityName);
                if (cityName.contains("Majestic")) {
                    option.click();
                }
            }
        }
    }
}
