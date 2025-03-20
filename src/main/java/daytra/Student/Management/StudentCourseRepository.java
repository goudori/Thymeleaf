package daytra.Student.Management;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * MySQLのstudents_coursesのテーブルから全てのコース情報を検索する。
 */
@Mapper
@Repository
public interface StudentCourseRepository {

  @Select("""
      SELECT 
        ID, 
        student_ID AS studentId, 
        Course_name AS courseName, 
        Course_feature AS courseFeature, 
        course_start_date AS courseStartDate, 
        course_end_date  AS courseEndDate
      FROM students_courses""")
  List<StudentCourse> searchCourse();

}
