package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import repository.MemberDao;

public class MemberListService implements MemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 모든 서비스는 응답을 이용해서 응답을 직접 만들어 이동한다. 응답할 데이터는 JSON으로 통일 /  리퀘스트는 파라미터 이용이 있을시에 사용
		// 요청하는  jsp 와 응답하는 jsp가 같은 것이 ajax이다 ( 요청과 응답이 동일한 곳에서 진행된다)
		
		// 응답 데이터 형식(JSON)
		response.setContentType("application/json; charset=UTF-8");
		
		// 응답 데이터 만들기
		/*
		 	{
		  		"count" : 3,
		  		"members" : [
		  			{
		  				"memberNo" : 1,
		  				"id" : "user1",
		  				"name" : "회원1",
		  				"gender" : "M",
		  				"grade" : "gold",
		  				"address" : "jeju"
		  			} ,
		  			{
		  				"memberNo" : 2,
		  				"id" : "user2",
		  				"name" : "회원2",
		  				"gender" : "F",
		  				"grade" : "silver",
		  				"address" : "seoul"
		  			} ,
		  			{
		  				"memberNo" : 3,
		  				"id" : "user3",
		  				"name" : "회원3",
		  				"gender" : "M",
		  				"grade" : "bronze",
		  				"address" : "yeosu"
		  			}
		  		]
		  	}
		 */
		JSONObject obj = new JSONObject();
		obj.put("count", MemberDao.getInstance().selectAllMembersCount());
		obj.put("members", MemberDao.getInstance().selectAllMembers());
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());		// JSON문자열
		out.close();
		
		System.out.println(obj.toString());
		
		
		
	}

}
