package Student.Management.controller.converter;

import Student.Management.data.Student;
import Student.Management.data.StudentCourse;
import Student.Management.domain.StudentDtail;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

  public List<StudentDtail> convertStudentDetails(List<Student> students,
      List<StudentCourse> studentCourses) {
    // コンバーターはここから
    List<StudentDtail> studentDtails = new ArrayList<>();
    // 個々の Student に対応する StudentCourse を取得
    students.forEach(student -> {
      StudentDtail studentDtail = new StudentDtail();
      studentDtail.setStudent(student);
      List<StudentCourse> convertStudentCourses = studentCourses.stream()
          .filter(studentCourse -> Integer.valueOf(student.getId())
              .equals(studentCourse.getStudentId())) // Integer 同士の比較
          .toList(); // Java 16 以降の場合。古い Java バージョンでは `collect(Collectors.toList())` を使う
      studentDtail.setStudentCourses(convertStudentCourses);
      studentDtails.add(studentDtail);
    }); // コンバーターはここまで
    return studentDtails;
  }

}
