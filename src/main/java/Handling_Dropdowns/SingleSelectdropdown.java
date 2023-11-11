package Handling_Dropdowns;

import com.microsoft.playwright.*;

import java.util.Collections;

public class SingleSelectdropdown {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://demo.automationtesting.in/Register.html");
            /*
            Seleccting dropdown using page.selectOption()
             */
            page.selectOption("#Skills","Java");
            /*
            Selecting dropdown using page.locator().selectOption()
             */
            page.locator("#yearbox").selectOption("1923");
        }
    }
}
