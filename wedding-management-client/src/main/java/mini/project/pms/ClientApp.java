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
          + "(5) 회원 상세 보기  (6) 회원 탈퇴  \n"
          + "(7) 회원 매칭       (0) 나가기           (99) 종료\n"
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
    // 클라이언트가 서버에 stop 명령을 보내면 다음 변수를 true로 변경한다.
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
      // 서버를 멈추기 위해 그냥 접속했다가 끊는다.
      try (Socket socket = new Socket(host, port)) {
        // 아무것도 안한다.
        // 서버가 stop 할 기회를 주기 위함이다.
      } catch (Exception e) {
        // 아무것도 안한다.
      }
    }
  }

  private static void receiveResponse(PrintWriter out, BufferedReader in) throws Exception {
    while (true) {
      String response = in.readLine();
      if (response.length() == 0) {
        break;
      } else if (response.equals("!{}!")) {
        // 사용자로부터 값을 입력을 받아서 서버에 보낸다.
        out.println(Prompt.inputString(""));
        out.flush(); // 주의! 출력하면 버퍼에 쌓인다. 서버로 보내고 싶다면 flush()를 호출하라!
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
      case 6: command = "/member/delete"; break;
      case 7: command = "/member/match"; break;
      case 99: command = "stop"; break;
      default: command = "  "; break;
    }
    return command;
  }

}




















