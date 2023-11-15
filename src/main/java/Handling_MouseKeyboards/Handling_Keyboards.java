package Handling_MouseKeyboards;

import com.microsoft.playwright.*;

import java.util.Collections;

public class Handling_Keyboards {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
                            .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://www.amazon.in/");
            ElementHandle amzn_text = page.querySelector("#twotabsearchtextbox");
            // Type text in to the field
            amzn_text.type("Nike shoes");
            // Enter key to search
//            amzn_text.press("Enter");
            // To clear the search text
            amzn_text.press("Control+A");
            amzn_text.press("Backspace");
            // delay between the text and keyboard presses
//            amzn_text.type("Puma shoes",new ElementHandle.TypeOptions().setDelay(100));
//            amzn_text.press("Enter");
            Keyboard keyboard = page.keyboard();
            keyboard.type("hellooo",new Keyboard.TypeOptions().setDelay(100));
            keyboard.press("Enter");
        }
    }
}
