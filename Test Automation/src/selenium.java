import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class selenium {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application");

    }
        @Test
        public void clickNavBarElements() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://2nhaber.com/");
        WebElement navbar = driver.findElement(By.cssSelector("#menu-1-5dc673f1"));
        List<WebElement> navLinks = navbar.findElements(By.cssSelector(".elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top"));

            for (WebElement link : navLinks) {
                String linkText = link.getText();
                String originalUrl = driver.getCurrentUrl();

                link.click();

                if (!driver.getCurrentUrl().equals(originalUrl)) {
                    System.out.println("Başarılı.");
                } else {
                    System.out.println("Başarısız");
                }

                driver.navigate().back();

                navbar = driver.findElement(By.cssSelector("#menu-1-5dc673f1"));
                navLinks = navbar.findElements(By.cssSelector(".elementor-widget-cmsmasters-nav-menu__dropdown-item elementor-widget-cmsmasters-nav-menu__item-link-top"));
            }

        }

        @Test
        public void viewPage8() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.get("https://2nhaber.com/");
            WebElement searchButton = driver.findElement(By.cssSelector(".e-font-icon-svg e-fas-search"));
            WebElement searchInput = driver.findElement(By.cssSelector(".elementor-widget-cmsmasters-search__field "));
            searchInput.sendKeys("İstanbul");
            searchInput.submit();

            Thread.sleep(2000);
            List<WebElement> newsList = driver.findElements(By.cssSelector(".page-numbers"));

            int targetNewsIndex = 4;
            if (newsList.size() >= targetNewsIndex) {
                WebElement targetNews = newsList.get(targetNewsIndex - 1);
                String expectedNewsTitle = targetNews.getText();
                targetNews.click();

                WebElement newsTitle = driver.findElement(By.tagName("h1"));
                System.out.println("Başarılı");
            }
                else {
                System.out.println("Başarısız");
            }


         }

         @Test
        public void applyJob() throws InterruptedException {

                 WebDriver driver = new ChromeDriver();
                 driver.get("https://www.2ntech.com.tr/hr");
                 driver.findElement(By.cssSelector("#name")).sendKeys("Melih Kostak");
                 driver.findElement(By.cssSelector("#birth")).sendKeys("23.08.2001");
                 driver.findElement(By.cssSelector("#tcKimlik")).sendKeys("11111111111");
                 driver.findElement(By.cssSelector("#email")).sendKeys("melih1kostak@gmail.com");

                 WebElement uploadElement = driver.findElement(By.cssSelector(".flex-1 bg-[#F5F5F5] text-[#6E6E6E] py-3 px-2 rounded-l-md cursor-pointer text-nowrap"));
                 uploadElement.sendKeys("C:\\Users\\AHMET MELİH KOSTAK\\Desktop");


                 driver.findElement(By.cssSelector(".py-3 px-4 w-full rounded-md transition-all bg-[#F5F5F5] text-[#6E6E6E] hover:bg-[#DF1F29] hover:text-white")).click();
                 driver.findElement(By.cssSelector(".bg-[#F5F5F5] py-3 px-2 rounded-md")).click();
                 driver.findElement(By.cssSelector(".w-8 h-8 flex justify-center items-center p-2 bg-[#DF1F29] rounded-full")).click();

                 WebElement positionDropdown = driver.findElement(By.cssSelector(".flex flex-wrap gap-2"));
                 positionDropdown.click();

                 driver.findElement(By.cssSelector(".text-white flex justify-center items-center text-[14px] py-2 px-4 rounded-full bg-[#DF1F29] cursor-pointer")).click();

                 WebElement successMessage = driver.findElement(By.cssSelector("#success_message"));
                 Assert.assertTrue("Başarı mesajı alınamadı.",
                         successMessage.isDisplayed());

                 System.out.println("Başarılı");


         }

}



