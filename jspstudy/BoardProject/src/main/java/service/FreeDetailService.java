package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDao;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		int freeNo = Integer.parseInt(opt.orElse("0"));
		
		Free free = FreeDao.getInstance().selectFreeNo(freeNo);
		
		if( free != null) {
			request.setAttribute("free", free);
			
			ActionForward af = new ActionForward();
			af.setView("/free/detail.jsp");
			af.setRedirect(false);
			return af; 
		}
		
		return null;
	}

}
