package daytra.Student.Management;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application.javaクラスを実行した後に、ブラウザのＵＲＬの場合は、http://localhost:8080/nameと入力して、「Tom James」と表示します。
 * <p>
 * Terminalもしくは、GitBashの場合は、GetMappingの場合は、 curl http://localhost:8080/nameと入力する。
 * PostMappingの場合は、curl -X POST http://localhost:8080/nameと入力する。
 * <p>
 * PostMappingのmapstudentの場合は、curl -X POST "http://localhost:8080/mapstudent" -d "name=値" -d
 * "age=値"を入力する。
 * <p>
 * GetMappingのstudentStatusの場合は、curl "http://localhost:8080/studentStatus"を入力する。
 */
@SpringBootApplication
@RestController
public class Application {

  // 名前のフィールド
  private String name = "Tom James";

  // 年齢のフィールド
  private int age = 20;

  // Mapの名前と年齢のフィールド
  private Map<String, Integer> student = new HashMap<>();


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  // GetMappingのname
  @GetMapping("/name")
  public String getName() {
    return name;
  }

  // GetMappingのstudentinfo
  @GetMapping("/studentinfo")
  public String getStudentInfo() {
    String studentAge = String.valueOf(age); // valueOfを使ってageのintを文字列に変換
    return name + "さんは、" + studentAge + "歳です。";
  }

  // GetMappingのstudentStatus(学生の名前と年齢を確認)
  @GetMapping("/studentStatus")
  public Map<String, Integer> getStudentStatus(){
    return student;
  }


  //　PostMappingのname
  @PostMapping("/name")
  public String setName(String name) {
    this.name = name;
    return StringUtils.EMPTY;
  }

  // PostMappingのmapstudent(学生の名前と年齢を登録する)
  @PostMapping("/mapstudent")
  public String setMapStudent(@RequestParam String name, @RequestParam int age) {
    this.student.put(name, age);
    return name + "さんは" + age + "歳です。";
  }


}
