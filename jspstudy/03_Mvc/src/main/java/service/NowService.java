package service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class NowService implements MyService{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// NodwService가 하는 일
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a h:mm:ss");
		String now = sdf.format(date);
		
		request.setAttribute("result", now);
		
		// 어디로 갈 것인가? (응답 Jsp 명시)
		ActionForward actionForward = new ActionForward();
		actionForward.setView("views/result.jsp");
		
		// ActionForward 반환
		return actionForward;
		
	}

}
