package Student.Management.domain;

import Student.Management.data.Student;
import Student.Management.data.StudentCourse;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 学生の詳細情報を格納しているクラス
 */
@Getter
@Setter
public class StudentDtail {

  private Student student;

  private List<StudentCourse> studentCourses;
}
