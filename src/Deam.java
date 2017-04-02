import org.junit.Test;

import javax.servlet.http.Cookie;
import java.util.UUID;

/**
 * Created by pc on 17-4-1.
 */
public class Deam  {
    @Test
    public void deam1(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().replace("-","");
        Cookie cookie = new Cookie("id",id);

        System.out.println(id);

    }
}
