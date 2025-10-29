package learning.testcase;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class Gmail {
    public static void main(String[] args) {
        //css
        //xpath
        //text

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

            page.navigate("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&dsh=S-737417469%3A1761693820092908&ifkv=ARESoU14SP0KpkgboBsA5uo7XDnuNTJsc88S7ZSz7wnyigZXtx5f7zbxvBza3zAEv6bpglzbyHCv&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//            page.locator("#identifierId").fill("testjava8378@gmail.com");
            page.fill("#identifierId", "trainer@way2automation.com");
            page.click("text=Next");
            page.locator("[type=password]").fill("abcndkle");
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
