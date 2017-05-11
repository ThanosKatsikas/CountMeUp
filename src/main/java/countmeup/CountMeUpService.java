package countmeup;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/* 
 * Service for the CMU controller. 
 */
@Service
public interface CountMeUpService {

	ResponseEntity<Void> doVote(int voterId, int candidateId);
	void doResults ();
	
	
}
