package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Board {
	private int boardNo;			// 기존 board_no로한 이유(언더바) : 데이터베이스 칼럼 이름과 맞추기 위해서
	private String title;
	private String content;
	private Date createDate;

}
