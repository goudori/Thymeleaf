package daytra.Student.Management;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 実行した後に、ブラウザのＵＲＬにlocalhost:8080/えいと入力して、「ちょや」と表示します。
 * <p>
 * StringUtilsExample.javaを実行すると、TomCatの一番下の行に空文字列(str1)、null(str2)、Hello, World!(str3)を判定します。
 */
@SpringBootApplication
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @GetMapping("/えい")
  public String hello() {
    StringUtilsExample.main(null); // StringUtilsExample.javaを実行
    return "ちょや";
  }


}
