
package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
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
      out.println("[회원 등록]");

      Member member = new Member();
      out.println("★ 입력하신 정보는 변경할 수 없습니다.\n★ 신중하게 입력하시길 바랍니다.");
      member.setId(Prompt.inputString("● 아이디? ", out, in));
      member.setPassword(Prompt.inputString("● 비밀번호? ", out, in));
      member.setName(Prompt.inputString("● 이름? ", out, in));

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

      member.setAge(Prompt.inputInt("● 나이? ", out, in));
      member.setTel(Prompt.inputString("● 전화번호? ", out, in));
      member.setHobby(Prompt.inputString("● 취미? ", out, in));

      int personalNo = 0;
      while (true) {
        personalNo = Prompt.inputInt("● 회원님의 성격 유형을 입력해주세요. (택 1)\n"
            + "(1) 다정한 (2) 자신감 넘치는 (3)성실한\n"
            + "(4) 꼼꼼한 (5) 외향적인 (6) 내성적인\n"
            + "(7) 자상한 (8) 끈기있는 (9) 낙천적인\n> ", out, in);
        if (personalNo >= 0 && personalNo < 10) {
          member.setGender(personalNo);
          break;
        } else {
          out.println("다시 입력해주세요!");
        }
      }

      member.setMbti(Prompt.inputString("- MBTI? ", out, in));
      member.setRegisteredDate(new Date(System.currentTimeMillis()));

      memberList.add(member);
      out.printf("%s님의 정보를 저장했습니다.", member.getName());

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}