package BrowserHandling;

import com.microsoft.playwright.*;

import java.util.Collections;

public class LaunchMultiple_CHromiumBrowsers {
    public static void main(String[] args) {
        String[] browsers = {"chrome", "msedge"};
        try (Playwright playwright = Playwright.create()) {
            /*
            For launching chromium browser -- chrome,edge and opera
            step1-> need to create browsercontext array to hold all the browsers
             */
            BrowserContext[] contexts = new BrowserContext[2];
            /*
            step2->l launching multiple browser using for loop
             */

            for (int i = 0; i < 2; i++) {
                Browser browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)
                                .setChannel(browsers[i])
                                .setArgs(Collections.singletonList("--start-maximized"))
                );
                contexts[i] = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            }
            /*
            step3-> After launching if any action need to done
            using for each loop
             */
            for (BrowserContext context : contexts) {
                Page page = context.newPage();
                page.navigate("https://facebook.com");
            }
            /*
            step4-> after all actions done
            close te browser
             */
            for (BrowserContext context : contexts) {
                context.close();
            }
        }
    }
}
