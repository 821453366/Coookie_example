import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 记录上次访问网站的时间
 * Created by pc on 17-3-30.
 */
@WebServlet(name = "Cookie_Servlet",urlPatterns = "/Cookie_Servlet")
public class Cookie_Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String lastTime=null;
        Cookie [] cookies = request.getCookies();
        for(int i=0 ;cookies!=null&&i<cookies.length;i++){
            if("time2".equals(cookies[i].getName())){
                lastTime=cookies[i].getValue();
                break;
            }
        }
        if(lastTime==null){
            response.getWriter().println("您今天第一次访问该网站");
        }else {
            response.getWriter().print("您上次访问时间为："+lastTime);
        }
        String time = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date());
        Cookie cookie=new Cookie("time2",time);
        response.addCookie(cookie);
    }
}
