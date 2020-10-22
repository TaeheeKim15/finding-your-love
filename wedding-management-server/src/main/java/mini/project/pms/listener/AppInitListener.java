package mini.project.pms.listener;

import java.util.Map;
import mini.project.context.ApplicationContextListener;

public class AppInitListener implements ApplicationContextListener {
  @Override
  public void contextInitialized(Map<String,Object> context) {
    System.out.println("시스템을 시작했습니다!");
  }

  @Override
  public void contextDestroyed(Map<String,Object> context) {
    System.out.println("시스템을 종료합니다!");
  }
}
