package countmeup;

import java.util.HashMap;

public class Poll {	
	HashMap<Integer, Candidate> candidateMap;
	HashMap<Integer, Voter> voterMap;

	Poll() {
		candidateMap = new HashMap<Integer,Candidate>();
		voterMap =new HashMap<Integer,Voter>();
		
		// Initialize four candidates
		for (int i = 0; i< 4; i++) {
			candidateMap.put(i, new Candidate(i));
		}
	}
	
	boolean castVote (int voterId, int candidateId ) {
		if (voterMap.get(voterId) == null) {
			voterMap.put(voterId, new Voter(voterId));
		}
		if (voterMap.get(voterId).canVote())
		{
			voterMap.get(voterId).doVote();
			candidateMap.get(candidateId).addVote();
			return true;
		}
		return false;
		
	}
		
	void getResults () {}
}
