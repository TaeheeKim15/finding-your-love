package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import mini.project.pms.domain.Member;

public class MaleListCommand implements Command {

  List<Member> memberList;

  public MaleListCommand(List<Member> list) {
    this.memberList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("---------[남성 회원 목록]---------");

    Iterator<Member> iterator = memberList.iterator();

    while (iterator.hasNext()) {
      Member member = iterator.next();
      if (member.getGender() == 2) {
        out.printf("%s님(%d세), %s을/를 즐깁니다.\n",
            member.getName(),
            member.getAge(),
            member.getHobby());
      } else {
        continue;
      }
    }
  }

}
