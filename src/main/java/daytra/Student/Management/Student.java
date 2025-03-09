package daytra.Student.Management;

/**
 * Student.javaは、「学生の名前」と「年齢」の情報を格納する型
 */
public class Student {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  private String name;

  private int age;
}
