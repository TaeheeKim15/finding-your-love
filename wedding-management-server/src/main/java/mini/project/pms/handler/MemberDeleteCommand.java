package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.pms.domain.Member;
import mini.project.util.Prompt;

public class MemberDeleteCommand implements Command {
  List<Member> memberList;

  public MemberDeleteCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[회원 탈퇴]");

      String id = Prompt.inputString("● 탈퇴하려는 아이디를 입력하세요. > ", out, in);
      Member member = findById(id);

      if (member == null) {
        out.println("입력하신 아이디의 회원을 찾을 수 없습니다.");
        return;
      }

      String password = member.getPassword();
      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (!response.equalsIgnoreCase("y")) {
        out.println("회원 삭제를 취소하였습니다.");
        return;
      }

      String input = Prompt.inputString("● 비밀번호를 입력하세요. >", out, in);
      if (!input.equalsIgnoreCase(password)) {
        out.println("비밀번호가 일치하지 않습니다.");
        return;
      }

      memberList.remove(member);
      out.println("회원 탈퇴가 완료되었습니다.");
      out.println("♥ Finding your love... ♥ 를 이용해주셔서 감사합니다.");
      out.println(""
          + "                               \n"
          + "     ,;;;;;;\\     ,;;;;;;,\n"
          + "   ,;;;@@@@@/   /;;@@@@@;;;,\n"
          + "  ,;;;@@,;;;\\   \\,@,;;;,@@;;;,\n"
          + "  ;;;@@;;;' '\\   \\;' ';;;@@;;;\n"
          + "  ;;;@@;;;   /   /    ;;;@@;;;\n"
          + "   ;;;@@';;, \\   \\  ,;;'@@;;;\n"
          + "    ';;;@@';;,\\   \\;;'@@;;;'\n"
          + "      ';;;@@';/   /'@@;;;'\n"
          + "        ';;;@/   /@@;;;' see you later!\n"
          + "          ';/   /;@;;'   bye.....♥\n"
          + "                \\;'\n");

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
}
