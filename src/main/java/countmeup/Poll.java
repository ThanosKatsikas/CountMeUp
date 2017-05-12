package countmeup;

import java.util.HashMap;
import java.util.LinkedList;
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
		
	List<Result> getResults () {
		List<Result> Results = new LinkedList<Result>();
		
		for (HashMap.Entry<Integer, Candidate> entry : candidateMap.entrySet())
		{
			Results.add(new Result(entry.getKey(), entry.getValue().getNumberOfVotes()));
		    System.out.println(entry.getKey() + "/" + entry.getValue().getNumberOfVotes());
		}
		return Results;
	}
}
