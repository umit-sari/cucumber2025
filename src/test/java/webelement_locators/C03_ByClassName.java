package webelement_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class C03_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");

        WebElement aramaKutusu = driver.findElement(By.className("search-input"));
        aramaKutusu.sendKeys("phone");

        // Alternatif: submit() kullanımı
        // aramaKutusu.submit();

        Thread.sleep(2000);  // WebDriverWait kullanımı önerilir

        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.className("prod-img"));

        System.out.println("Bulunan urun sayisi : " + bulunanUrunElementleriList.size());

        if (!bulunanUrunElementleriList.isEmpty()) {
            System.out.println("Urun arama Testi PASSED");
        } else {
            System.out.println("Urun arama Testi FAILED");
        }

        // Ürün isimlerini yazdırma
        for (WebElement eachElement : bulunanUrunElementleriList) {
            System.out.println(eachElement.getText());
        }

    // yontem dogru ama isim elementi barindiran HTML elementlerin
    // class attribute degerleri space icerdigi icin bu soruda kullanamadik
    // ilk urunu tiklayin
    // listede 0.index'teki elementi click yapabiliriz

        if (!bulunanUrunElementleriList.isEmpty()) {
            bulunanUrunElementleriList.get(0).click();
        } else {
            System.out.println("Ürün bulunamadı, tıklama işlemi yapılamadı.");
        }


    // acilan urun sayfasindaki urun detaylarinda
    // case sensitive olmadan "phone" kelimesi gectigini test edin

    String expectedIsimIcerik = "phone";

    WebElement urunDetayElementi =driver.findElement(By.className("prod-detail"));

    String urunDetayi = urunDetayElementi
            .getText()
            .toLowerCase();

        if (urunDetayi.contains(expectedIsimIcerik)){
        System.out.println("Urun detay testi PASSED");
    }else System.out.println("Urun detay testi FAILED");


    // sayfayi kapatin

        Thread.sleep(2000);
        driver.close();
   }
}
