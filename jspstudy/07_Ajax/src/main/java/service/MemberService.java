package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// ajax는 페이지 이동이 없는 방식이다  ( 페이지 이동이 있으면(화면이 깜빡이면) mvc )
}
