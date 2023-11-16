package TakeScreenshots;

import com.microsoft.playwright.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class CroptheScreenshots {
    public static void main(String[] args) throws InterruptedException, IOException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            byte[] screenshots;
            screenshots = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
            byte[] croppedScreenshot = cropScreenshot(screenshots, 10, 10, 50, 30);
            Path outputPath = Paths.get(".//src//main//resources//Screesnhots//CropedScreenshot.png");
            try {
                java.nio.file.Files.write(outputPath, screenshots);
                System.out.println("Full-page screenshot saved to: " + outputPath.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private static byte[] cropScreenshot(byte[] screenshot, int left, int top, int width, int height)
            throws IOException {
        BufferedImage Actual_Screenshot = ImageIO.read(new ByteArrayInputStream(screenshot));
        BufferedImage croppedImage = Actual_Screenshot.getSubimage(left, top, width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(croppedImage, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
}