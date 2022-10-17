
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowService implements MyService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("a h:mm:ss");
		String now = sdf.format(date);
		
		request.setAttribute("result", now);
		
	}

}
