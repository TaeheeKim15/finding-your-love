package mini.project.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import mini.project.util.Prompt;

public class ClientApp {

  static String host;
  static int port;

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("프로그램 사용법:");
      System.out.println("  java -cp ... ClientApp 서버주소 포트번호");
      System.exit(0);
    }

    host = args[0];
    port = Integer.parseInt(args[1]);

    System.out.println("\n"
        + "            ♥ Finding your love... ♥\n"
        + "            ╱▔▔╲╱▔▔╲┊┊╭━━━━━━━━━━━━\n"
        + "            ▏┈╭╮╭╮┈▕┊┊┃ Finding\n"
        + "            ╲┈┏━━┓┈╱┊╭┫ your Love♥\n"
        + "            ┊╲╰━━╯╱━━╯╰━━━━━━━━━━━━\n"
        + "            ┊┊╲┈┈╱┊┊┊┊┊┊┊┊  ♥    ♥\n"
        + "            ┊┊┊╲╱┊┊┊┊┊┊┊┊┊♥    ♥   ♥");

    while (true) {
      System.out.println("\n"
          + "        ♥ 원하는 번호를 입력하세요! ♥  (예: 1)\n"
          + "------------------------------------------------------\n"
          + "(1) 회원 등록       (2) 전체 회원 조회 \n"
          + "(3) 여성회원 조회   (4) 남성회원 조회 \n"
          + "(5) 회원 상세 보기  (6) 회원 매칭  \n"
          + "(7) 회원 탈퇴       (0) 나가기           (99) 종료\n"
          + "------------------------------------------------------\n");
      String input = commandBoard(Prompt.inputInt("명령> "));

      if (input.equalsIgnoreCase("quit"))
        break;

      request(input);

      if (input.equalsIgnoreCase("stop"))
        break;
    }
    System.out.println("다음에 또 만나요!");
    System.out.println(""
        + " _                \n"
        + "| |               \n"
        + "| |__  _   _  ___ \n"
        + "| '_ \\| | | |/ _ \\\n"
        + "| |_) | |_| |  __/\n"
        + "|_.__/ \\__, |\\___|\n"
        + "        __/ |     \n"
        + "       |___/    ");

  }

  private static void request(String message) {
    boolean stop = false;

    try (Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      out.println(message);
      out.flush();

      receiveResponse(out, in);

      if (message.equalsIgnoreCase("stop")) {
        stop = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (stop) {
      try (Socket socket = new Socket(host, port)) {
      } catch (Exception e) {
      }
    }
  }

  private static void receiveResponse(PrintWriter out, BufferedReader in) throws Exception {
    while (true) {
      String response = in.readLine();
      if (response.length() == 0) {
        break;
      } else if (response.equals("!{}!")) {
        out.println(Prompt.inputString(""));
        out.flush();
      } else {
        System.out.println(response);
      }
    }
  }

  private static String commandBoard(int num) {
    String command = null;
    switch(num) {
      case 0: command = "quit"; break;
      case 1: command = "/member/add"; break;
      case 2: command = "/member/list"; break;
      case 3: command = "/femaleMember/list"; break;
      case 4: command = "/maleMember/list"; break;
      case 5: command = "/member/detail"; break;
      case 6: command = "/member/match"; break;
      case 7: command = "/member/delete"; break;
      case 99: command = "stop"; break;
      default: command = "  "; break;
    }
    return command;
  }

}




















