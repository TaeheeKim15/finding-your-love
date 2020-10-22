package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import mini.project.pms.domain.Member;

public class FemaleListCommand implements Command {

	List<Member> femaleList;

	public FemaleListCommand(List<Member> list) {
		this.femaleList = list;
	}

	@Override
	public void execute(PrintWriter out, BufferedReader in) {
		out.println("[여성회원 목록]");

		// 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
		// 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
		Iterator<Member> iterator = femaleList.iterator();

		while (iterator.hasNext()) {
			Member member = iterator.next();
			out.printf("%s, %d, %s\n",
					member.getName(),
					member.getAge(),
					member.getHobby());
		}
	}


	public Member findByName(String name) {
		for (int i = 0; i < femaleList.size(); i++) {
			Member femaleMember = femaleList.get(i);
			if (femaleMember.getName().equals(name) && femaleMember.getGender() == 1) {
				return femaleMember;
			}
		}
		return null;
	}

}
