package service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.StudentDao;

public class StudentFindService implements StudentService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		double begin = Double.parseDouble(request.getParameter("begin"));
		double end = Double.parseDouble(request.getParameter("end"));
		
		
		// DB로 보낼 Map 생성
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("begin", begin);
		map.put("end", end);
		
		
		// StudentDao 생성
		StudentDao dao = StudentDao.getInstance();
		
		// request에 필요한 정보 저장하기
		request.setAttribute("students", dao.selectStudentsByAve(map));
		request.setAttribute("count", dao.selectStudentsByAveCount(map));
		request.setAttribute("average", dao.selectStudentsByAveAverage(map));

		// student/list.jsp로 포워딩
		return new ActionForward("/student/list.jsp", false);
	}

}
