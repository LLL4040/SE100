package wordladder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("*")
@Controller
@RequestMapping("/wordladder")
public class GreetingController {
    static private boolean logged = false;
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/search")
    public @ResponseBody String greeting(
            @RequestParam(value="begin") String begin,
            @RequestParam(value="end") String end) {
        if(logged) {
            Greeting ladder = new Greeting(counter.incrementAndGet(), begin, end);
            return ladder.getLadder();
        }
        else
            return "未登录请先登录";
    }

    @RequestMapping("/login")
    public @ResponseBody boolean login(
            @RequestParam(value = "username") String name,
            @RequestParam(value = "password") String pwd) {
        String url = "http://checkhost:9090/check?username="+name+"&password="+pwd;
        RestTemplate restTemplate= new RestTemplate();
        Boolean res =restTemplate.getForObject(url,Boolean.class);
        if(res)
        {
            logged= true;
            return true;
        }
        else
            return false;
    }
}
