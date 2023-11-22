package FileHandlings;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class File_Uploading {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
            page.locator("//input[@name='upfile']").setInputFiles(Paths.get("./src/main/resources/FileHandling_Docx/demo1.txt"));
            page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Press")).click();
            page.close();
            context.close();
            playwright.close();
            /*
            Parameterized tests
             */
        }
    }
}
