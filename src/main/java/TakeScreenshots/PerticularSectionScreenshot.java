package TakeScreenshots;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BoundingBox;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class PerticularSectionScreenshot {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            Locator about_us = page.getByText("About Us");
            about_us.scrollIntoViewIfNeeded();
            about_us.evaluate("element => { element.style.border = '2px solid red'; }");
            byte[] screenshots;
            screenshots = about_us.screenshot();
            Path outputPath = Paths.get(".//src//main//resources//Screesnhots//full_page_screenshot1.png");
            try {
                java.nio.file.Files.write(outputPath, screenshots);
                System.out.println("Element screenshot saved to: " + outputPath.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
