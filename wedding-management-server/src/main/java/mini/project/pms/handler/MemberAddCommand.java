
package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.pms.domain.Member;
import mini.project.util.Prompt;

public class MemberAddCommand implements Command {

  List<Member> memberList;

  public MemberAddCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[신규 회원 등록]");

      Member member;
      out.println("★ 입력하신 정보는 변경할 수 없습니다.\n★ 신중하게 입력하시길 바랍니다.");

      String id;
      while (true) {
        id = Prompt.inputString("● 아이디? ", out, in);
        if (!stringValidCheck(out, id)) {
          continue;
        }
        member = findById(id);
        if (member != null) {
          out.println("입력하신 아이디는 이미 사용중입니다.");
          out.println("다른 아이디를 입력해주세요.");
        } else {
          member = new Member();
          member.setId(id);
          break;
        }
      }

      String password;
      while (true) {
        password = Prompt.inputString("● 비밀번호? ", out, in);
        if (!stringValidCheck(out, password)) {
          continue;
        }
        member.setPassword(password);
        break;
      }

      String name;
      while (true) {
        name = Prompt.inputString("● 이름? ", out, in);
        if (!nullCheck(out, name)) {
          continue;
        }
        member.setName(name);
        break;
      }

      int genderNo = 0;
      while (true) {
        genderNo = Prompt.inputInt("● 성별?\n  1: 여자\n  2: 남자\n>", out, in);
        if (genderNo == 1 || genderNo == 2) {
          member.setGender(genderNo);
          break;
        } else {
          out.println("다시 입력해주세요!");
        }
      }

      int age;
      while (true) {
        age = Prompt.inputInt("● 나이? ", out, in);
        if (!nullCheck(out, age)) {
          continue;
        }
        member.setAge(age);
        break;
      }

      String tel;
      while (true) {
        tel = Prompt.inputString("● 전화번호? ", out, in);
        if (!nullCheck(out, tel)) {
          continue;
        }
        member.setTel(tel);
        break;
      }

      String hobby;

      while (true) {
        hobby = Prompt.inputString("● 취미? ", out, in);
        if (!nullCheck(out, hobby)) {
          continue;
        }
        while (isStringDouble(hobby) == true) {
          hobby = Prompt.inputString("숫자를 입력하실 수 없습니다. 재입력해주세요.\n"
              + "● 취미? ", out, in);
        }
        member.setHobby(hobby);
        break;
      }

      int personalNo = 0;
      while (true) {
        personalNo = Prompt.inputInt("● 회원님의 성격 유형을 입력해주세요. (택 1)\n"
            + "(1) 다정한 (2) 자신감 넘치는 (3) 성실한\n"
            + "(4) 꼼꼼한 (5) 외향적인 (6) 내성적인\n"
            + "(7) 자상한 (8) 끈기있는 (9) 낙천적인\n> ", out, in);
        if (personalNo >= 0 && personalNo < 10) {
          member.setPersonal(personalNo);
          break;
        } else {
          out.println("다시 입력해주세요!");
        }
      }

      memberList.add(member);

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  public Member findById(String id) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  public boolean nullCheck(PrintWriter out, String input) {
    boolean validity = true;
    if (input.length() == 0) {
      out.println("입력된 데이터가 없습니다.");
      validity = false;
    }
    return validity;
  }

  public boolean nullCheck(PrintWriter out, int input) {
    boolean validity = true;
    if (input == 0) {
      out.println("입력된 데이터가 없습니다.");
      validity = false;
    }
    return validity;
  }

  public boolean stringValidCheck(PrintWriter out, String input) {
    boolean validity = true;
    nullCheck(out, input);
    if (input.length() < 3 || input.length() > 16) {
      out.println("입력 조건을 확인하시길 바랍니다.");
      out.println("(영문과 숫자 조합 3자 이상, 15자 이하)");
      validity = false;
    }
    return validity;
  }

  public static boolean isStringDouble(String hobby) {
    try {
      Double.parseDouble(hobby);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

}












