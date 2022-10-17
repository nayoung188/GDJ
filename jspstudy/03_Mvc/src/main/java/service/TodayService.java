package service;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class TodayService implements MyService{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// NodwService가 하는 일
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		
		// 뷰(jsp)로 전달할 데이터는 request에 속성으로 저장한다.
		request.setAttribute("result", today);
		
		// 어디로 갈 것인가? (응답 Jsp 명시)
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		
		// ActionForward 반환
		return actionForward;
	}

}
