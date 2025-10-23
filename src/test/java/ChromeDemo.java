import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDemo {
    public static void main(String[] args) {
        // Tự động tải ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Tạo instance ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Mở trang Google
            driver.get("https://www.youtube.com/watch?v=yebNIHKAC4A");

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
