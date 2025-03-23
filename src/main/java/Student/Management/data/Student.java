package Student.Management.data;


import lombok.Getter;
import lombok.Setter;

/**
 * Student.javaは、学生情報を格納している型
 */
@Getter
@Setter
public class Student {

  private String name;
  private String furigana;
  private String nickName;
  private String email;
  private String address;
  private String sex;
  private int age;
  private int id;

}

