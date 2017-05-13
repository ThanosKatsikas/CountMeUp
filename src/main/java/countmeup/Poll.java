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
				
		// Initialize four candidates
		for (int i = 1; i<= numberOfCandidates; i++) {
			storeData.setCandidate(i);
		}
	}
	
	public synchronized boolean castVote (int voterId, int candidateId ) {
		if (storeData.getVoter(voterId) == null) {
			storeData.setVoter(voterId);
		}
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
	
	public StoreData getStoreData() {
		return storeData;
	}
}
