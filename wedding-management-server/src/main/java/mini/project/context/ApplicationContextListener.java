package mini.project.context;

import java.util.Map;

public interface ApplicationContextListener {
  // 발행자(애플리케이션)가 애플리케이션 시작을 알리기 위해 호출하는 메서드
  // => 발행자와 옵저버 간에 데이터를 공유하기 위해 맵 파라미터 추가
  void contextInitialized(Map<String,Object> context);

  // 발행자(애플리케이션)가 애플리케이션 종료를 알리기 위해 호출하는 메서드
  void contextDestroyed(Map<String,Object> context);
}
