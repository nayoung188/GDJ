import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TodayService implements MyService{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		
		request.setAttribute("result", today);
	}

}
