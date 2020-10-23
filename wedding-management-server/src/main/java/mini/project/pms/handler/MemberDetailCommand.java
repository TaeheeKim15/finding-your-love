package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.pms.domain.Member;
import mini.project.util.Prompt;

public class MemberDetailCommand implements Command {

  List<Member> memberList;

  public MemberDetailCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("---------------------[회원 상세 보기]---------------------");

      String name = Prompt.inputString("● 이름? ", out, in);
      Member member = findByName(name);

      if (member == null) {
        out.println("★ 해당 이름으로 등록된 회원이 없습니다.");
        return;
      }

      out.printf("♥ %s님의 정보는 아래와 같습니다.\n", member.getName());
      out.println("-----------------------------------");

      String genderLabel = null;
      switch (member.getGender()) {
        case 1:
          genderLabel = "여성";
          break;
        case 2:
          genderLabel = "남성";
          break;
        default:
          genderLabel = "성별 정보 없음";
      }
      out.printf("성별: %s\n", genderLabel);
      out.printf("나이: %s세\n", member.getAge());
      out.printf("취미: %s\n", member.getHobby());
      out.printf("성격: %s 성격\n", personalBoard(member.getPersonal()));
      out.println("-----------------------------------");

      out.printf("♥ %s님의 연락처가 궁금하신가요?\n", member.getName());
      out.println("♥ 프리미엄 서비스에 가입하세요!\n");
      out.println("----------------------------------------------------------");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  public Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }

  private String personalBoard(int personalNo) {
    String a = null;
    switch(personalNo) {
      case 1: return a = "다정한";
      case 2: return a = "자신감 넘치는";
      case 3: return a = "성실한";
      case 4: return a = "꼼꼼한";
      case 5: return a = "외향적인";
      case 6: return a = "내성적인";
      case 7: return a = "자상한";
      case 8: return a = "끈기있는";
      case 9: return a = "낙천적인";
    }
    return a;
  }

}
