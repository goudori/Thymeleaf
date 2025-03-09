package daytra.Student.Management;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * StudentRepository.javaは、SQLを書く為のMySQL専用のインターフェイス
 * <p>
 * nameとは、MySQLのstudentテーブルのnameカラム
 * <p>
 * 1.名前を検索する。 nameを引数に受け取り、Student.javaのfindByNameメソッドを呼び出す
 * <p>
 * 2.名前と年齢を新しく登録(新しく追加)する。 nameとageを引数に受け取り、Student.javaのregisterStudentメソッドを呼び出す
 * <p>
 * 3.名前と年齢を更新する。 nameとageを引数に受け取り、Student.javaのupdateStudentメソッドを呼び出す
 * <p>
 * 4.名前を削除する。 nameを引数に受け取り、Student.javaのdeleteStudentメソッドを呼び出す
 */
@Mapper
public interface StudentRepository {

  // 1.MySQLのstudentテーブルのnameカラムを検索する( Student SearchByName(String name)メソッドの処理)
  @Select("SELECT * FROM student WHERE name = #{name}")
  // #{name}とは、 Student SearchByName(String name);を指します。#{name}に値を入れる
  Student SearchByName(String name); // Student.javaのfindByNameメソットを呼び出ず

  // 2.MySQLのstudentテーブルにnameとageを新しく登録(新しく追加)する。(void registerStudent(String name, int age)メソッドの処理)
  @Insert("INSERT student values(#{name}, #{age})")
  void registerStudent(String name, int age);

  //3 . MySQLのstudentテーブルの名前と年齢を更新する。
  @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
  void updateStudent(String name, int age);

  //4. MySQLのstudentテーブルの名前を削除する。
  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);
}
