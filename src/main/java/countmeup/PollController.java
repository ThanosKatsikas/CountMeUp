package countmeup;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PollController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to count me up! \n";
    }

}
