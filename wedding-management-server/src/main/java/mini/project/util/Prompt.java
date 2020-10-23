package mini.project.util;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static String inputString(
      String title, PrintWriter out, BufferedReader in) throws Exception {
    out.println(title);
    out.println("!{}!");
    out.flush();
    return in.readLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static int inputInt(
      String title,
      PrintWriter out,
      BufferedReader in) throws Exception {
    return Integer.parseInt(inputString(title, out, in));
  }

  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  public static Date inputDate(
      String title,
      PrintWriter out,
      BufferedReader in) throws Exception {
    return Date.valueOf(inputString(title, out, in));
  }

  public static void close() {
    keyboardScan.close();
  }
}
