package countmeup;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PollController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to count me up! \n";
    }
    
    @RequestMapping(value = "/vote", method=RequestMethod.POST)
    public void vote(
    		@RequestParam(value="voter") String voter, 
    		@RequestParam(value="candidate") String candidate,
    		@RequestParam(value="numberVotes", defaultValue="1", required=false) int numberVotes,
    		@RequestParam(value="poll", defaultValue="1", required=false) int poll)
    {
    	
    }
    
    @RequestMapping(value = "/results", method=RequestMethod.GET)
    public void results(
    		@RequestParam(value="poll", defaultValue="1", required=false) int poll,
    		@RequestParam(value="candidate", defaultValue="0", required=false) int numberOfVotes)
    {
    	
    }

}
