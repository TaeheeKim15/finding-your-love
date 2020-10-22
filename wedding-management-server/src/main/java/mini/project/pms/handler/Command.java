package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface Command {
  void execute(PrintWriter out, BufferedReader in);
}
