package BrowserHandling;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.util.Properties;

public class LaunchMultipleBrowsers {
    private static Properties loadProperties() {
        Properties properties = new Properties();
        properties.setProperty("browser1", "chrome");
        properties.setProperty("browser2", "firefox");
        return properties;
    }
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Properties properties = loadProperties();
            BrowserContext[] contexts = new BrowserContext[properties.size()];
            Browser[] browsers = new Browser[properties.size()];
            int index = 0;
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                if (key.startsWith("browser")) {
                    String browserType = properties.getProperty(key);
                    Browser browser = null;
                    BrowserContext context = null;
                    switch (browserType) {
                        case "chrome":
                            browser = playwright.chromium().launch(
                                    new BrowserType.LaunchOptions().setHeadless(false)
                            );
                            System.out.println("Chrome launching");
                            break;
                        case "firefox":
                            browser = playwright.firefox().launch(
                                    new BrowserType.LaunchOptions().setHeadless(false)
                            );
                            System.out.println("Firefox launching");
                            break;
                    }
                    if (browser != null) {
                        browsers[index] = browser;
                        contexts[index] = browser.newContext();
                        Page page = contexts[index].newPage();
                        page.navigate("https://facebook.com");
                        page.waitForLoadState(LoadState.NETWORKIDLE);
                        page.close();
                        index++;
                    }
                }
            }
            for (int i = 0; i < browsers.length; i++) {
                if (contexts[i] != null) {
                    contexts[i].close();
                }
            }
        } catch (PlaywrightException e) {
            e.printStackTrace();
        }
    }
}
