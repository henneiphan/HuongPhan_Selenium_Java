package Buoi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnhIT_UpdateInfo {
    public static void main(String[] args) throws InterruptedException {
        // Thiết lập WebDriverManager
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang đăng nhập
        driver.get("https://anhitsolutions.com/login");
        Thread.sleep(5000);

        // Nhập thông tin đăng nhập
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));

//        username.sendKeys("huong.phan@gmail.com");
//        password.sendKeys("Pass@123");
        username.sendKeys("henneiphan08@gmail.com");
        password.sendKeys("Huong@020308");

        // Nhấn nút Đăng nhập
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        loginBtn.click();

        Thread.sleep(3000); // chờ load dashboard

        // Click vào menu "Cài đặt"
        WebElement settingMenu = driver.findElement(By.xpath("//span[text()='Cài đặt']"));
        settingMenu.click();

        Thread.sleep(3000); // chờ trang cài đặt load

        // Lấy giá trị email hiện tại
        WebElement currentEmail = driver.findElement(By.name("email"));
        String actualEmail = currentEmail.getAttribute("value");
        String expectedCurrentEmail = "henneiphan08@gmail.com";

        if (actualEmail.equals(expectedCurrentEmail)) {
            System.out.println("✅ TC PASSED - Email khớp: " + actualEmail);
        } else {
            System.out.println("❌ TC FAILED - Email thực tế: " + actualEmail);
        }

        // --- 1. Cập nhật đầy đủ thông tin ---
        WebElement fullName = driver.findElement(By.name("full_name"));
        WebElement phone = driver.findElement(By.name("mobile"));
        WebElement email = driver.findElement(By.name("email"));

        fullName.clear();
        phone.clear();
        email.clear();

        String expectedName = "Phan Hường";
        String expectedPhone = "0328425009";
        String expectedEmail = "henneiphan08@gmail.com";

        fullName.sendKeys(expectedName);
        phone.sendKeys(expectedPhone);
        email.sendKeys(expectedEmail);

        // Lưu lại thông tin cơ bản
        WebElement saveBtn1 = driver.findElement(By.xpath("//button[contains(text(),'Lưu lại')]"));
        saveBtn1.click();

        Thread.sleep(3000);

        // So sánh actual vs expected
        String actualName = fullName.getAttribute("value");
        String actualPhone = phone.getAttribute("value");
        System.out.println("✅ actualPhone : " + actualPhone);

        if (actualPhone.equals(expectedPhone)) {
            System.out.println("✅ TC PASSED - Họ tên khớp: " + actualPhone);
        } else {
            System.out.println("❌ TC FAILED - Họ tên thực tế: " + actualPhone);
        }

        Thread.sleep(5000);

        // --- 2. Cập nhật phần Giới thiệu ---
        driver.findElement(By.xpath("//a[@data-original-title='Giới thiệu']")).click();
//        driver.get("https://anhitsolutions.com/panel/setting/step/3");
        Thread.sleep(5000);

        WebElement about = driver.findElement(By.name("about"));
        WebElement bio = driver.findElement(By.name("bio"));

        about.clear();
        bio.clear();

        String expectedAbout = "Tester Junior";
        String expectedBio = "Tôi là QA với hơn 2 năm kinh nghiệm kiểm thử web và mobile.";

        about.sendKeys(expectedAbout);
        bio.sendKeys(expectedBio);

        WebElement saveBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Lưu lại')]"));
        saveBtn2.click();

        Thread.sleep(3000);

        // So sánh actual vs expected
        String actualAbout = about.getAttribute("value");
        String actualBio = bio.getAttribute("value"); // textarea nên dùng getAttribute("value")

        if (actualAbout.equals(expectedAbout)) {
            System.out.println("✅ TC PASSED - About khớp: " + actualAbout);
        } else {
            System.out.println("❌ TC FAILED - About thực tế: " + actualAbout);
        }

        if (actualBio.equals(expectedBio)) {
            System.out.println("✅ TC PASSED - Bio khớp: " + actualBio);
        } else {
            System.out.println("❌ TC FAILED - Bio thực tế: " + actualBio);
        }

        // Đóng trình duyệt
        driver.quit();
    }
}
