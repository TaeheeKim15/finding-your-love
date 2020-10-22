package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import mini.project.pms.domain.Member;

public class MemberListCommand implements Command {

  List<Member> memberList;

  public MemberListCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[전체 회원 목록]");

    Iterator<Member> iterator = memberList.iterator();

    while (iterator.hasNext()) {
      Member member = iterator.next();
      out.printf("%s님(%d세, %s), %s을/를 즐깁니다.\n",
          member.getName(),
          member.getAge(),
          isWoman(member.getGender()),
          member.getHobby());
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

  public String isWoman(int gender) {
    String a = null;
    if (gender == 1) {
      a = "여성";
    } else {
      a = "남성";
    }
    return a;
  }

}
