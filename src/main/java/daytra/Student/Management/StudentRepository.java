package daytra.Student.Management;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * StudentRepository.javaは、SQLを書く為のMySQL専用のインターフェイス
 * <p>
 * AS(エイリアス) → カラムの別名をつける　(例:full_nameをnameという別名にする)
 * <p>
 * AS nameとは、MySQLのstudentテーブルのfull_nameカラム
 *
 *
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

  // MySQLのstudentsテーブルの全てのカラムを検索する( Student SearchByName(String name)メソッドの処理)
  @Select("""
        SELECT 
          full_name AS name, 
          furigana, 
          nick_name AS nickName,
          email, 
          address, 
          sex, 
          age, 
          id 
        FROM students
      """)
  List<Student> search();


}
