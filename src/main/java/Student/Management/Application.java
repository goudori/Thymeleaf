package Student.Management; // SpringBootのパッケージ名


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.RestController;


/**
 * 　Webアプリを起動するクラス
 */
@SpringBootApplication
@RestController
public class Application {


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


}
