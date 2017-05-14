package countmeup;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CountMeUpController {

	private final CountMeUpService countMeUpService;
	
	@Autowired
	public CountMeUpController(final CountMeUpService countMeUpService) {
		this.countMeUpService = countMeUpService;
	}
	
    @RequestMapping("/")
    public String index() {
        return "Welcome to count me up! \n";
    }
    
    @RequestMapping(value = "/vote", method=RequestMethod.POST)
    public ResponseEntity<Void> vote(
    		@RequestParam(value="voter") int voter, 
    		@RequestParam(value="candidate") int candidate)
    {
    	return countMeUpService.doVote(voter, candidate);
    }
    
    @RequestMapping(value = "/results", method=RequestMethod.GET)
    public List<Candidate> results()
    {
    	return countMeUpService.doResults();
    }

}
