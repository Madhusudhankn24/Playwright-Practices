package HandlingCheckbox;

import com.microsoft.playwright.*;

import java.util.Collections;

public class CheckBox_complexWebTable {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
            /*
            First we need to locate the WebTable
            tableID->example->tr
             */
            Locator rows = page.locator("table#example tr");
            /*
            In Dynamic values we need to check one row so that
            using scope we can get the entire row based on the value(text)
            from that we will select checkbox
             */
            rows.locator(":scope",new Locator.LocatorOptions()
                    .setHasText("Cara Stevens")).locator(".select-checkbox").click();
            /*
            To print evry rows on console
             */
            rows.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));

        }
    }
}
