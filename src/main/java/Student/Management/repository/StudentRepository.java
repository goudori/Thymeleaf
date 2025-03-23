package Student.Management.repository;

import Student.Management.data.Student;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * StudentRepository.javaは、SQLを書く為のMySQL専用のインターフェイス
 * <p>
 * AS(エイリアス) → カラムの別名をつける　(例:full_nameをnameという別名にする)
 * <p>
 * AS nameとは、MySQLのstudentテーブルのfull_nameカラム
 * <p>
 * 学生情報を検索するインターフェース
 */
@Mapper
public interface StudentRepository {


  /**
   * @return　全ての学生情報を検索する
   */
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
