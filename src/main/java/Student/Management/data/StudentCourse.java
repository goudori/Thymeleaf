package Student.Management.data;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 * StudentCourse.javaは、学生のコース情報の型を管理する
 */
@Getter
@Setter
public class StudentCourse {

  private int id;
  private int studentId;
  private String courseName;
  private String courseFeature;
  private Timestamp courseStartDate;
  private Timestamp courseEndDate;
}
