package BrowserHandling;

import com.microsoft.playwright.*;

import java.util.Collections;

public class LaunchCHome_Firefox_AtaTime {
    public static void main(String[] args) {
        String[] Chromium_browsers = {"chrome", "msedge"};
        try (Playwright playwright = Playwright.create()) {
            /*
            Launching chromium and firefox browsers at a time
            need to create Browser array to hold both browsers
             */
            Browser[] browsers = new Browser[2];
            /*
            1-> launching chromium browsers
             */
            int i = 0;
            browsers[0] = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setChannel(Chromium_browsers[i])
                            .setArgs(Collections.singletonList("--start-maximized")));
            /*
            2-> launching firefox browsers
             */
            browsers[1] = playwright.firefox().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            /*
            After launching we need perform actions
            using for each loop
             */
            for (Browser browser : browsers) {
                BrowserContext context = browser.newContext(
                        new Browser.NewContextOptions().setViewportSize(null));
                Page page = context.newPage();
                page.navigate("https://facebook.com");

            }
            /*
            Closing the browsers
             */
            for (Browser browser : browsers) {
                browser.close();
            }
        }
    }
}

