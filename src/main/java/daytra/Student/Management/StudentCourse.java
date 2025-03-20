package daytra.Student.Management;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

/**
 * Student.javaは、学生のコース情報の型を管理する
 */
@Getter
@Setter
public class StudentCourse {

  private int ID;
  private int studentId;
  private String courseName;
  private String courseFeature;
  private Timestamp courseStartDate;
  private Timestamp courseEndDate;
}
