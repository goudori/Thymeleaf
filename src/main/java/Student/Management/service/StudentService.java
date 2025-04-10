package Student.Management.service;

import Student.Management.data.Student;
import Student.Management.data.StudentCourse;
import Student.Management.repository.StudentCourseRepository;
import Student.Management.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Controllerから呼び出されるサービスクラス
 */
@Service
public class StudentService {

  private final StudentRepository repository;

  private final StudentCourseRepository courseRepository;


  /**
   * @param repository       → 学生情報を検索する
   * @param courseRepository →　コース情報を検索する
   */
  @Autowired
  public StudentService(StudentRepository repository, StudentCourseRepository courseRepository) {
    this.repository = repository;
    this.courseRepository = courseRepository;
  }


  /**
   * @return 全学生の情報を検索する
   */
  public List<Student> searchStudentList() {

    return repository.search();
  }

  /**
   * @return 20歳以上の学生だけを検索する
   */
  public List<Student> searchStudentListByAge() {
    return repository.searchByAge();
  }


  /**
   * @return 全学生の備考情報を検索する
   */
  public List<Student> searchRemark() {
    return repository.searchRemark();
  }

  /**
   * @return 全学生のコース情報を検索する
   */
  public List<StudentCourse> searchStudentCourseList() {
    return courseRepository.searchCourse();
  }


  /**
   * ＠return AWSコースの情報のみを検索する
   */
  public List<StudentCourse> searchAwsCourse() {
    return courseRepository.searchAwsCourse();
  }


  /**
   * @return プレースホルダーを使って、Javaコースの情報のみ検索する
   */
  public List<StudentCourse> searchJavaCourse() {
    return courseRepository.searchJavaCourse("Javaコース");
  }
}
