package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import mini.project.pms.domain.Board;

public class BoardListCommand implements Command {

  List<Board> boardList;

  public BoardListCommand(List<Board> list) {
    this.boardList = list;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    out.println("[게시물 목록]");

    Iterator<Board> iterator = boardList.iterator();

    while (iterator.hasNext()) {
      Board board = iterator.next();
      out.printf("%d, %s, %s, %s, %d\n",
          board.getNo(),
          board.getTitle(),
          board.getWriter(),
          board.getRegisteredDate(),
          board.getViewCount());
    }
  }

}
