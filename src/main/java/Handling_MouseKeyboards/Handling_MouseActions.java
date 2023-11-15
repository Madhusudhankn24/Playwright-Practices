package Handling_MouseKeyboards;

import com.microsoft.playwright.*;

import java.util.Collections;

public class Handling_MouseActions {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            /*
            Scroll Actions
            1--> scroll down
             */
            page.evaluate("window.scrollBy(0, 500);");
            Locator about_us = page.getByText("About Us");
            /*
            2-> scroll down for specific element
             */
            about_us.scrollIntoViewIfNeeded();
            /*
            3-> hover over the element
             */
            about_us.hover();
            /*
            4-> Right click on the element
             */
            ElementHandle facebook = page.querySelector(".nav_first");
//            facebook.contextMenu();
            /*
            5-> double click the element
             */
            about_us.dblclick();
        }
    }
}
