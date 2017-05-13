package countmeup;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountMeUpServiceImpl implements CountMeUpService{
	
	// TODO: Add configuration class and yml file to load the number of Candidates
	private final Poll poll = new Poll(4);
	
	@Override
	public ResponseEntity<Void> doVote(int voterId, int candidateId) {
		HttpHeaders headers = new HttpHeaders();
		
		if (poll.castVote(voterId, candidateId) ) {
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		return  new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);	
	}

	@Override
	public List<Candidate> doResults() {
		return poll.getResults();
		
	} 


}
