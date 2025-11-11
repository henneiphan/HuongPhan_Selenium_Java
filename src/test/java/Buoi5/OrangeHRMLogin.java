package Buoi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLogin {
    public static void main(String[] args) throws InterruptedException {
        // Khởi tạo trình duyệt
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang web lên
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);

        // Nhập dữ liệu username và mật khẩu
            // 1. Khai báo biến element xpath
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            // 2. Nhập dữ liệu
        username.sendKeys("Admin");
        password.sendKeys("admin123");

        // Click Login button
        driver.findElement(By.xpath("//button[text()= ' Login ']")).click();
    }
}

