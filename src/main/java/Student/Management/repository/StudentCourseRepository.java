package Student.Management.repository;

import Student.Management.data.StudentCourse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * MySQLのstudents_coursesのテーブルから全てのコース情報を検索する。
 */
@Mapper

public interface StudentCourseRepository {

  /**
   * @return　全てのコース情報を検索する
   */
  @Select("""
      SELECT 
        id, 
        student_id AS studentId, 
        course_name AS courseName, 
        course_feature AS courseFeature, 
        course_start_date AS courseStartDate, 
        course_end_date  AS courseEndDate
      FROM students_courses""")
  List<StudentCourse> searchCourse();

}
