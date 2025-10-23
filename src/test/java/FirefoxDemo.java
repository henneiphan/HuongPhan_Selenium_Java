import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDemo {
    public static void main(String[] args) {
        // Tự động tải driver về
        WebDriverManager.firefoxdriver().setup();

        // Tạo instance của FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Truy cập trang web
            driver.get("https://www.geeksforgeeks.org/software-testing/selenium-with-java-tutorial/");

            System.out.println("Tiêu đề trang: " + driver.getTitle());
            System.out.println("URL trang: " + driver.getCurrentUrl());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }
}
