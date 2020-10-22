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
      out.println("[회원 상세보기]");
      String name = Prompt.inputString("이름? ", out, in);
      Member member = findByName(name);

      if (member == null) {
        out.println("해당 회원이 없습니다.");
        return;
      }

      out.printf("%님의 정보는 아래와 같습니다.\n", member.getName());
      out.printf("성별: %s\n", member.getGender());
      out.printf("나이: %s\n", member.getAge());
      out.printf("취미: %s\n", member.getHobby());
      out.printf("MBTI: %s\n", member.getMbti());
      out.printf("등록일: %s\n", member.getRegisteredDate());
      out.printf("%님의 연락처를 알고 싶으시면 프리미엄 서비스에 가입하세요!\n", member.getName());

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
}
