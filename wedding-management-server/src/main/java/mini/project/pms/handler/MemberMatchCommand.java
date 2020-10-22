package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import mini.project.pms.domain.Member;
import mini.project.util.Prompt;

public class MemberMatchCommand implements Command {

  List<Member> memberList;

  public MemberMatchCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    int personalNo = 0;

    out.println("[회원님 맞춤 이성 목록]");

    Iterator<Member> iterator = memberList.iterator();

    try {

      int genderNo = 0;
      while (true) {
        genderNo = Prompt.inputInt("- 회원님의 성별을 입력해주세요\n  1: 여자\n  2: 남자\n>", out, in);
        if (genderNo == 1 || genderNo == 2) {
          break;
        } else {
          out.println("다시 입력해주세요!");
        }
      }

      while (true) {
        personalNo = Prompt.inputInt("- 회원님이 원하시는 이성의 성격 유형을 입력해주세요. (택 1)\n"
            + "(1) 다정한 (2) 자신감 넘치는 (3)성실한\n"
            + "(4) 꼼꼼한 (5) 외향적인 (6) 내성적인\n"
            + "(7) 자상한 (8) 끈기있는 (9) 낙천적인\n> ", out, in);
        if (personalNo >= 0 && personalNo < 10) {
          break;
        } else {
          out.println("다시 입력해주세요!");
        }
      }

      out.printf("%s 이성분들은 아래와 같습니다.\n",personalBoard(personalNo));
      int count = 0;
      while (iterator.hasNext()) {
        Member member = iterator.next();
        if (member.getGender() != genderNo && member.getPersonal() == personalNo) {
          ++count;
          out.printf("<< %d번 회원님 >>\n"
              + "이름 : %s\n"
              + "나이 : %d\n"
              + "MBTI : %s\n"
              + "%s 를(을) 즐기는 회원\n",
              count,
              member.getName(),
              member.getAge(),
              member.getMbti(),
              member.getHobby());
          out.println("---------------");
        } else {
          continue;
        }
      }

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }

  }

  private String personalBoard(int personalNo) {
    String a = null;
    switch(personalNo) {
      case 1: return a = "다정한"; 
      case 2: return a ="자신감 넘치는";
      case 3: return a ="성실한"; 
      case 4: return a ="꼼꼼한";
      case 5: return a ="외향적인"; 
      case 6: return a ="내성적인";
      case 7: return a ="자상한";
      case 8: return a ="끈기있는";
      case 9: return a ="낙천적인";
    }
    return a;
  }

}
