package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Board;

public class BoardDao {
	
	// field - SqlSessionFactory
	private SqlSessionFactory factory;
	
	// singleton - pattern
	private static BoardDao dao = new BoardDao();
	private BoardDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static BoardDao getInstance() {
		return dao;
	}
	
	// 모든 method는 SqlSessionFactory로부터 SqlSession을 얻어서 사용
	// method
	
	// Tip. 메소드 이름을 실행할 쿼리문의 id와 맞추자.
	
	// 1. 게시글 목록
	public List<Board> selectAllBoards(){
		SqlSession ss = factory.openSession();		// select용 opensession  / SELECT(커밋이 필요 없는 경우)
		List<Board> boards = ss.selectList("mybatis.mapper.board.selectAllBoards");		// mybatis.mapper.board 매퍼의 selectAllBoards 아이디를 가진 쿼리문 실핼
		ss.close(); 		// 메소드마다 닫아주어야 한다.
		return boards;
	}
	
	// 2. 게시글 상세 보기
	public Board selectBoardByNo(int boardNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("mybatis.mapper.board.selectBoardByNo", boardNo);		// boardNo를 파라미터로 전달
		ss.close();
		return board;
	}
	
	// 3. 게시글 삽입
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession(false);			//INSERT (커밋이 필요한 경우)
		int result = ss.insert("mybatis.mapper.board.insertBoard", board);		// board를 파라미터로 전달
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}

	// 4. 게시글 삭제
	public int deleteBoard(int boardNo) {		
		SqlSession ss = factory.openSession(false);			// UPDATE (커밋이 필요한 경우) 
		int result = ss.delete("mybatis.mapper.board.deleteBoard", boardNo);
		if(result > 0 ) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	// 5. 게시글 수정
	public int updateBoard(Board board) {
		SqlSession ss = factory.openSession(false);			// UPDATE (커밋이 필요한 경우) 
		int result = ss.update("mybatis.mapper.board.updateBoard", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	
	
	
	

}
