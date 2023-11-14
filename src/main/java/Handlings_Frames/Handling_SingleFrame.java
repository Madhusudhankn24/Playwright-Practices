package Handlings_Frames;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.Collections;

public class Handling_SingleFrame {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(
                            Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://demo.automationtesting.in/Frames.html");
            /*
            Using frameLocator we can locate the frames
             */
            page.frameLocator("#singleframe").getByRole(AriaRole.TEXTBOX)
                    .fill("madhu");

        }
    }
}
