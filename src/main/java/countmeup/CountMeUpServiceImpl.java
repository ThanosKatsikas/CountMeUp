package countmeup;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountMeUpServiceImpl implements CountMeUpService{
	
	private final Poll poll = new Poll();
	
	@Override
	public ResponseEntity<Void> doVote(int voterId, int candidateId) {
		HttpHeaders headers = new HttpHeaders();
		
		if (poll.castVote(voterId, candidateId) ) {
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		
		return  new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);	
	}

	@Override
	public List<Result> doResults() {
		return poll.getResults();
		
	} 


}
