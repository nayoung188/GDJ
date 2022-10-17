import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyService {
   public void execute(HttpServletRequest reuqest, HttpServletResponse response);
}