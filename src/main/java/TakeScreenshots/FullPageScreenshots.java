package TakeScreenshots;

import com.microsoft.playwright.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class FullPageScreenshots {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://amazon.com");
            byte[] screenshots;
            /*
            To capture entire page we need to use setfullpage
             */
            screenshots = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            Path outputPath = Paths.get(".//src//main//resources//Screesnhots//full_page_screenshot1.png");
            try {
                Files.write(outputPath, screenshots);
                System.out.println("Full-page screenshot saved to: " + outputPath.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
