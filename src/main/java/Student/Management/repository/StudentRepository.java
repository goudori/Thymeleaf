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
          remark,
          age,
          id,
          isDeleted
        FROM students
      """)
  List<Student> search();

  /**
   * 20歳以上の学生だけを検索する
   */
  @Select("""
      SELECT
         full_name AS name,
         furigana,
         nick_name AS nickName,
         email,
         address,
         sex,
         remark,
         age,
         id,
         isDeleted,
         FROM students
         WHERE age >= 20""")
  List<Student> searchByAge();


  /**
   * @return 学生の備考を検索する
   */
  @Select("""
      SELECT
        full_name AS name,
        furigana,
        nick_name AS nickName,
        email,
        address,
        sex,
        remark,
        age,
        id,
        isDeleted
      FROM students
      WHERE remark IS NOT NULL
      """)
  List<Student> searchRemark();

}
