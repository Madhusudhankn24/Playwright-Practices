package FileHandlings;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class FileDownloading {
    public static void main(String[] args) {
        try(Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Collections.singletonList("--start-maximized")));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));
            Page page = context.newPage();
            page.navigate("https://filesamples.com/formats/pdf");
            Download download = page.waitForDownload(()->{
                page.click("a[href*='sample3']");
            });
//            download.saveAs(Paths.get("./src/main/resources/FileHandling_Docx/downloadedox.pdf"));

            Path path = Paths.get(System.getProperty("user.dir"),"FileHandling_Docx");
            if (Files.exists(path)){
                File downloadsFile = new File(path+"downloaded_file.pdf");
                if (downloadsFile.exists()){
                    System.out.println("File Exits");
                }else {
                    System.out.println("File can not available");
                }
            }
            page.close();
            context.close();
            playwright.close();
        }
    }
}
