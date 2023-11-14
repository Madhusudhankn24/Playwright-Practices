package Handling_Dropdowns;

import com.microsoft.playwright.*;

import java.util.Collections;

public class MultiSelectdropdownlist {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://letcode.in/dropdowns");
            /*
            Locating multiple list dropdown
             */
            Locator multi_list_DD = page.locator("#superheros");
            multi_list_DD.selectOption(new String[] {"am","bw","ds"});
        }
    }
}
