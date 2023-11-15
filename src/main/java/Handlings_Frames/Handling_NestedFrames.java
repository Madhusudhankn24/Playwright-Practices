package Handlings_Frames;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.Collections;

public class Handling_NestedFrames {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setArgs(
                            Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://demo.automationtesting.in/Frames.html");
            page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Iframe with in an Iframe")).click();
            page.frameLocator("[src='MultipleFrames.html']")
                    .frameLocator("[src='SingleFrame.html']").getByRole(AriaRole.TEXTBOX).fill("hello");
        }
    }
}
