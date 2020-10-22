package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import mini.project.pms.domain.Member;

public class MaleListCommand implements Command {

	List<Member> maleList;

	public MaleListCommand(List<Member> list) {
		this.maleList = list;
	}

	@Override
	public void execute(PrintWriter out, BufferedReader in) {
		out.println("[남성 회원 목록]");

		// 전체 목록을 조회할 때 `Iterator` 객체를 사용한다.
		// 만약 목록의 일부만 조회하면다면 인덱스를 직접 다루는 이전 방식을 사용해야 한다.
		Iterator<Member> iterator = maleList.iterator();

		while (iterator.hasNext()) {
			Member maleMember = iterator.next();
			out.printf("%s, %d, %s\n",
					maleMember.getName(),
					maleMember.getAge(),
					maleMember.getHobby());
		}
	}

	public Member findByName(String name) {
		for (int i = 0; i < maleList.size(); i++) {
			Member maleMember = maleList.get(i);
			if (maleMember.getName().equals(name) && maleMember.getGender() == 2) {
				return maleMember;
			}
		}
		return null;
	}

}
