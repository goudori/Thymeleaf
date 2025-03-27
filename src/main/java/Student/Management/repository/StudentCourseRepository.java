package Student.Management.repository;

import Student.Management.data.StudentCourse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * searchCourse()はMySQLのstudents_coursesのテーブルから全てのコース情報を検索する。
 * <p>
 * searchAwsCourse()はMySQLのstudents_coursesのテーブルからAWSコースの情報のみを検索する。
 * <p>
 * searchJavaCourse()はMySQLのstudents_coursesのテーブルからJavaコースの情報のみを検索する。
 * <p>
 * プレースホルダ-(SQLインジェクションを防ぐ)　→　#{courseName}
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

  /**
   * @return AWSコースの情報のみ検索する。
   */
  @Select("""
      SELECT
        id, 
        student_id AS studentId, 
        course_name, 
        course_feature AS courseFeature, 
        course_start_date AS courseStartDate, 
        course_end_date  AS courseEndDate
        FROM students_courses
        WHERE course_name = 'AWSコース'""")
  List<StudentCourse> searchAwsCourse();


  /**
   * @return プレースホルダーを使って、Javaコースの情報のみ検索する。
   */
  @Select("""
      SELECT
        id, 
        student_id AS studentId, 
        course_name, 
        course_feature AS courseFeature, 
        course_start_date AS courseStartDate, 
        course_end_date  AS courseEndDate
        FROM students_courses
        WHERE course_name = #{courseName}""")
  // プレースホルダー
  List<StudentCourse> searchJavaCourse(@Param("courseName") String courseName);

}
