package wordladder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/greeting")
    public @ResponseBody
    Greeting greeting(
            @RequestParam(value="begin") String begin,
            @RequestParam(value="end") String end) {
        return new Greeting(counter.incrementAndGet(), begin, end);
    }
}
