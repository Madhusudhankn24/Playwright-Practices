package VedioRecording;

import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.Collections;

public class Record_Execution {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null)
                    // using setRecordVedio we can record the execution
                    .setRecordVideoDir(Paths.get("./src/main/resources/Recording_vedios/"))
                    .setRecordVideoSize(1280, 720));
            Page page = context.newPage();
            page.navigate("https://facebook.com");
            context.close();
            playwright.close();
        }
    }
}
