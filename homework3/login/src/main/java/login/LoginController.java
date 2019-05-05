package login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
public class LoginController {
    @RequestMapping("/check")
    public @ResponseBody
    Boolean login(
            @RequestParam(value="username") String user,
            @RequestParam(value="password") String pwd) {
        if(user.equalsIgnoreCase("user") && pwd.equalsIgnoreCase("123"))
            return true;
        else
            return false;
    }
}
