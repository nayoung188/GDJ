package domain;

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

public class Student {
	private int stuNo;			// 기존 board_no로한 이유(언더바) : 데이터베이스 칼럼 이름과 맞추기 위해서
	private String name;
	private int kor, eng, math;
	private double ave;
	private String grade;

}
