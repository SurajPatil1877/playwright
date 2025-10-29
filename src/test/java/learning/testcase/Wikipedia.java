package learning.testcase;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.ArrayList;
import java.util.List;

public class Wikipedia {
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

            page.navigate("https://www.wikipedia.org/");
//            page.selectOption("#searchLanguage","mr");
            page.selectOption("#searchLanguage", new SelectOption().setLabel("मराठी"));

            Locator locator = page.locator("select > option");
            int count = locator.count();
            System.out.println(count);


            for (int i = 0; i < locator.count(); i++) {
                Locator nth = locator.nth(i);
                String s = nth.innerText() + "-------------" + nth.getAttribute("lang");
                System.out.println(s);
            }



            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
