package daytra.Student.Management;


import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * ①/studentListSearchは、全学生の情報を検索する。
 * <p>
 * ②/studentCourseListSearchは、全学生のコース情報を検索する。
 */
@SpringBootApplication
@RestController
@MapperScan("daytra.Student.Management")
public class Application {

  // StudentRepositoryのインスタンスを自動的に作成
  @Autowired
  private StudentRepository repository; // StudentRepositoryをrepositoryの名前にしてインスタンス化

  @Autowired
  private StudentCourseRepository courseRepository; // StudentCourseRepositoryをcourseRepositoryの名前にしてインスタンス化


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  // GetMapping

  // GetMappingで、全学生の情報を検索する。
  @GetMapping("/studentListSearch")
  public List<Student> getStudentList() {

    return repository.search(
    );

  }

  // GetMappingで、全学生のコース情報を検索する。
  @GetMapping("/studentCourseListSearch")
  public List<StudentCourse> getStudentCourseList() {
    return courseRepository.searchCourse();
  }


}
