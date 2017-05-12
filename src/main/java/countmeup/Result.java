package countmeup;
/*
 * Class Result
 * 
 * Attributes:
 * 			The candidate's ID and the number of votes he got. 
 * Methods:
 * 			Getters.
 */
public class Result {
	private final int candidateId;
	private final int votesNumber;
	
	Result (int candidateId, int votesNumber) {
		this.candidateId = candidateId;
		this.votesNumber = votesNumber;
	}
	
	public int getCandidateId () {
		return candidateId;
	}
	
	public int getVotesNumber () {
		return votesNumber;
	}
	
}
