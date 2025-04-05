package Student.Management.controller;


import Student.Management.controller.converter.StudentConverter;
import Student.Management.data.Student;
import Student.Management.data.StudentCourse;
import Student.Management.domain.StudentDtail;
import Student.Management.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ①/studentListSearchは、全学生の情報を検索する。(http://localhost:8080/studentListSearch)
 * <p>
 * ②/studentCourseListSearchは、全学生のコース情報を検索する。
 * <p>
 * ③/studentListSearchByAgeは、20歳以上の学生の情報だけ検索する。
 * <p>
 * ④/awsCourseListSearchは、AWSコースの情報のみを検索する。
 * <p>
 * ⑤/javaCourseListSearchは、Javaコースの情報のみを検索する。
 */
@Controller
public class StudentController {

  private StudentService service;

  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  // GetMappingで、全学生の情報を検索する。
  @GetMapping("/studentListSearch")
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentCourses = service.searchStudentCourseList();

    model.addAttribute("studentList", converter.convertStudentDetails(students,
        studentCourses)); // 受講生情報をHTMLに使えるようにする事。

    model.addAttribute("studentCourses", studentCourses); // コース情報をHTMLに使えるようにする事。
    return "studentList"; // studentList.htmlに返す
  }


  // GetMappingで、20歳以上の学生の情報だけ検索する。
  @GetMapping("studentListSearchByAge")
  public List<Student> getStudentListByAge() {
    return service.searchStudentListByAge();
  }


  // GetMappingで、全学生の備考だけ検索する。
  @GetMapping("studentRemarkSearch")
  public List<Student> getStudentRemark() {
    return service.searchRemark();
  }

  // GetMappingで、全学生のコース情報を検索する。
  @GetMapping("/studentCourseListSearch")
  public List<StudentCourse> getStudentCourseList() {
    return service.searchStudentCourseList();
  }

  // GetMappingで、AWSコースの情報のみを検索する。
  @GetMapping("/awsCourseListSearch")
  public List<StudentCourse> getAwsCourseList() {
    return service.searchAwsCourse();
  }


  // GetMappingで、Javaコースの情報のみを検索する。
  @GetMapping("/javaCourseListSearch")
  public List<StudentCourse> getJavaCourseList() {
    return service.searchJavaCourse();
  }


}
