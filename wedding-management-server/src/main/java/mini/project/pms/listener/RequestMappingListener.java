package mini.project.pms.listener;

import java.util.List;
import java.util.Map;
import mini.project.context.ApplicationContextListener;
import mini.project.pms.domain.Member;
import mini.project.pms.handler.FemaleListCommand;
import mini.project.pms.handler.HelloCommand;
import mini.project.pms.handler.MaleListCommand;
import mini.project.pms.handler.MemberAddCommand;
import mini.project.pms.handler.MemberDeleteCommand;
import mini.project.pms.handler.MemberDetailCommand;
import mini.project.pms.handler.MemberListCommand;
import mini.project.pms.handler.MemberMatchCommand;

// 클라이언트 요청을 처리할 커맨드 객체를 준비한다.
public class RequestMappingListener implements ApplicationContextListener {

  @SuppressWarnings("unchecked")
  @Override
  public void contextInitialized(Map<String,Object> context) {
    // 옵저버가 작업한 결과를 맵에서 꺼낸다.
    List<Member> memberList = (List<Member>) context.get("memberList");

    context.put("/hello", new HelloCommand());

    MemberListCommand memberListCommand = new MemberListCommand(memberList);
    context.put("/member/match", new MemberMatchCommand(memberList));
    context.put("/femaleMember/list", new FemaleListCommand(memberList));
    context.put("/maleMember/list", new MaleListCommand(memberList));
    context.put("/member/add", new MemberAddCommand(memberList));
    context.put("/member/list", memberListCommand);
    context.put("/member/detail", new MemberDetailCommand(memberList));
    context.put("/member/delete", new MemberDeleteCommand(memberList));
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
  }

}
