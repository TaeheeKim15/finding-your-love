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
      member.setId(Prompt.inputString("아이디? ", out, in));
      member.setName(Prompt.inputString("이름? ", out, in));

      int no = 0;
      while (true) {
        no = Prompt.inputInt("성별?\n1: 여자\n2: 남자\n>", out, in);
        if (no == 1 || no == 2) {
          member.setGender(no);
          break;
        } else {
          out.println("다시 입력해주세요!");
        }
      }

      member.setAge(Prompt.inputInt("나이? ", out, in));
      member.setTel(Prompt.inputString("전화번호? ", out, in));
      member.setHobby(Prompt.inputString("취미? ", out, in));
      member.setPersonal(Prompt.inputInt("성격? ", out, in));
      member.setMbti(Prompt.inputString("MBTI? ", out, in));
      member.setPassword(Prompt.inputString("비밀번호? ", out, in));
      member.setRegisteredDate(new Date(System.currentTimeMillis()));

      memberList.add(member);

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }
}
