package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Board;

public class BoardDao {
	
	private SqlSessionFactory factory;
	
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
	
	// 목록
	public List<Board> selectAllBoards(){
		SqlSession ss = factory.openSession();	
		List<Board> boards = ss.selectList("mybatis.mapper.board.selectAllBoards");
		ss.close(); 		
		return boards;
	}
	
	// 상세 보기
	public Board selectBoardByNo(int boardNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne("mybatis.mapper.board.selectBoardByNo", boardNo);		
		ss.close();
		return board;
	}
	
	// 삽입
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession(false);			
		int result = ss.insert("mybatis.mapper.board.insertBoard", board);		
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}

	// 삭제
	public int deleteBoard(int boardNo) {		
		SqlSession ss = factory.openSession(false);		
		int result = ss.delete("mybatis.mapper.board.deleteBoard", boardNo);
		if(result > 0 ) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	// 수정
	public int updateBoard(Board board) {
		SqlSession ss = factory.openSession(false);			
		int result = ss.update("mybatis.mapper.board.updateBoard", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	// 게시글 갯수
	public int selectAllBoardsCount() {
		SqlSession ss =factory.openSession();
		int count  = ss.selectOne("mybatis.mapper.board.selectAllBoardsCount" );
		ss.close();
		return count;
	}
	
	
	
	

}
