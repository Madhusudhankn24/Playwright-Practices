package TakeScreenshots;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class CroptheScreenshots {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            byte[] screenshots;
            screenshots = page.screenshot(new Page.ScreenshotOptions().setFullPage(false));
            Path outputPath = Paths.get(".//src//main//resources//Screesnhots//CropedScreenshot.png");
            try {
                java.nio.file.Files.write(outputPath, screenshots);
                System.out.println("Full-page screenshot saved to: " + outputPath.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}