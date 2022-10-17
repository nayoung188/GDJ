package service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MyService {
	
   public ActionForward execute(HttpServletRequest reuqest, HttpServletResponse response);
}