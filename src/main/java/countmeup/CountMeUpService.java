package countmeup;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/* 
 * Service for the CMU controller. 
 */
@Service
public interface CountMeUpService {

	ResponseEntity<Void> doVote(int voterId, int candidateId);
	List<Result>  doResults ();
	
	
}
