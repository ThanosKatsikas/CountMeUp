package countmeup;

import java.util.List;

/*
 * Class Poll
 * 
 * Attributes:
 * 			CandidateMap
 * 			VoterMap
 * Methods:
 * 			Constructor - Creates the maps and initializes four candidates.
 * 			
 * 			castVote - Casts a vote. Takes Voter's ID and Candidate's ID
 * 			as argument.
 * 
 *  		getResults - Get's the results of the voting. 	
 */
public class Poll {	
	private final StoreData storeData;

	
	Poll(int numberOfCandidates) {
		storeData = new StoreDataRuntime();
				
		// Initialize candidates.
		for (int i = 1; i<= numberOfCandidates; i++) {
			storeData.setCandidate(i);
		}
	}
	
	/* We want to ensure that casting a vote is atomic as there are
	 * racing conditions with multiple threads checking if one can vote. 
	 */
	public synchronized boolean castVote (int voterId, int candidateId ) {
		// If the voter doesn't exist in our storage, add him. 
		if (storeData.getVoter(voterId) == null) {
			storeData.setVoter(voterId);
		}
		//Check that the voter can vote and also that the candidate is valid.
		if (storeData.getVoter(voterId).canVote() && storeData.getCandidate(candidateId) != null)
		{
			storeData.getVoter(voterId).doVote();
			storeData.getCandidate(candidateId).addVote();
			return true;
		}
		return false;
	}
		
	public List<Candidate> getResults () {
		return storeData.getCandidates();
	}
	// Returns a way to access the storage.
	public StoreData getStoreData() {
		return storeData;
	}
}
