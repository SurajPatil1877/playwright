package learning.testcase;

import com.microsoft.playwright.*;


import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LaunchBrowser {
    public static void main(String[] args) {
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = (int) screenSize.getWidth();
//        int height = (int) screenSize.getHeight();


        List<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        BrowserType.LaunchOptions launchOptions =
                new BrowserType
                        .LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setArgs(arguments)
                        .setSlowMo(50);

        try (Playwright pw = Playwright.create();
             Browser browser = pw.chromium().launch(launchOptions);
//         BrowserContext browserContext = pw.chromium().launchPersistentContext(Paths.get(""),new BrowserType.LaunchPersistentContextOptions().setViewportSize(null));


             BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
             Page page = browserContext.newPage()) {

            page.navigate("https://www.google.com");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));


            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
