package com.gdu.app01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app01.domain.BoardDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> selectAllBoards();
	public BoardDTO selectBoardByNo(int boardNo);
	public int insertBoard(BoardDTO board);
	public int updateBoard(BoardDTO board);
	public int deleteBoard(int boardNo);
	public int deleteBoardList(List<String> boardNoList);
}