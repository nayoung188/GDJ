package com.gdu.app07;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.gdu.app07.config.BoardAppContext;
import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;


// Junit4를 사용한다
// 커스터마이징한 MySpringJunit4ClassRunner를 사용한다.
@RunWith(MySpringJUnit4ClassRunner.class)

// Bean은 BoardAppContext에 정의되어있다.
@ContextConfiguration(classes= {BoardAppContext.class})

public class BoardUnitTest {
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void 삽입테스트() {
		BoardDTO board = new BoardDTO(0, "텍스트제목", "텍스트내용", "텍스트작성자", null, null);
		assertEquals(1, dao.insertBoard(board));
	}

}
