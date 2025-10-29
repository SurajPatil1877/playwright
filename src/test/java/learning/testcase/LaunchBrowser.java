package learning.testcase;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class LaunchBrowser {
    public static void main(String[] args) {
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
             BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
             Page page = browserContext.newPage()) {

            page.navigate("https://www.google.com");
            Thread.sleep(2000);
            page.navigate("https://javadoc.io/doc/com.microsoft.playwright/playwright/latest/index.html");
            page.goBack(new Page.GoBackOptions().setTimeout(500));
            Thread.sleep(1000);
            page.goForward(new Page.GoForwardOptions().setTimeout(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

            //28
        }


    }
}
