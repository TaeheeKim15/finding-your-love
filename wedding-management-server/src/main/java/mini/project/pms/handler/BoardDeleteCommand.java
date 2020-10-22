package mini.project.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import mini.project.pms.domain.Board;
import mini.project.util.Prompt;

public class BoardDeleteCommand implements Command {

  List<Board> boardList;

  public BoardDeleteCommand(List<Board> list) {
    this.boardList = list;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in) {
    try {
      out.println("[게시물 삭제]");
      String writer = Prompt.inputString("작성자? ", out, in);
      Board board = findByName(writer);

      if (board == null) {
        out.println("해당 회원이 작성한 게시글이 없습니다.");
        return;
      }

      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ", out, in);
      if (response.equalsIgnoreCase("y")) {
        String password = Prompt.inputString("게시글 비밀번호를 입력하세요. \n> ", out, in);
        if (password.equalsIgnoreCase(board.getPassword())) {
          boardList.remove(board.getNo());
          out.println("게시글을 삭제하였습니다.");
        } else {
          out.println("비밀번호가 일치하지 않습니다.");
        }
        return;
      }

      out.println("게시글 삭제를 취소하였습니다.");

    } catch (Exception e) {
      out.printf("작업 처리 중 오류 발생! - %s\n", e.getMessage());
    }
  }

  private long indexOf(long no) {
    for (int i = 0; i < boardList.size(); i++) {
      Board board = boardList.get(i);
      if (board.getNo() == no) {
        return i;
      }
    }
    return -1;
  }

  public Board findByName(String writer) {
    for (int i = 0; i < boardList.size(); i++) {
      Board board = boardList.get(i);
      if (board.getWriter().equals(writer)) {
        return board;
      }
    }
    return null;
  }

}
