package HandlingCheckbox;

import com.microsoft.playwright.*;

import java.util.Collections;

public class CheckUncheck_Checkbox {
    public static void main(String[] args) throws InterruptedException {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(
                            Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://dev.automationtesting.in/form");
            Thread.sleep(5000);
            page.check("[value='automation_testing']");
            if (page.locator("[value='true']").isChecked()){
                Thread.sleep(5000);
                page.check("[value='true']");
            }
        }
    }
}
