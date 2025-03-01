package daytra.Student.Management;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtilsメソッドを実行するコードです。
 */
public class StringUtilsExample {

  public static void main(String[] args) {
    String str1 = "";
    String str2 = null;
    String str3 = "Hello, World!";
    String str4 = " ";

    // str1は空文字列なのでtrueを返す
    System.out.println("Is str1 empty? " + StringUtils.isEmpty(str1));  // true

    // str2はnullなのでtrueを返す
    System.out.println("Is str2 empty? " + StringUtils.isEmpty(str2));  // true

    // str3は文字が含まれているのでfalseを返す
    System.out.println("Is str3 empty? " + StringUtils.isEmpty(str3));  // false

    System.out.println("str3の値がある場合は" + StringUtils.isBlank(str3)); // false

    System.out.println("str4が空白の空文字の場合は、" + StringUtils.isBlank(str4)); // true


  }
}
