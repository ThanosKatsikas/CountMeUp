package countmeup;

import com.fasterxml.jackson.annotation.JsonProperty;

/* 
 * Class candidate
 * Attributes: 	
 * 			Unique identifier and number of votes.
 * Methods:	
 * 			Constructor - Sets the unique identifier
 * 			and his votes to zero. 
 * 				
 * 			GetNumberOfVotes - Returns number of votes
 * 			the candidate has.
 * 
 *   		addVote - Adds a vote to the candidate's votes
 */
public class Candidate {
	@JsonProperty
	private final int candidateId;
	@JsonProperty
	private int numberOfVotes;
	
	Candidate (int id) {
		candidateId = id;
		numberOfVotes = 0;
	}
	
	public int getNumberOfVotes() {
		return numberOfVotes;
	}
	
	public void addVote () {
		numberOfVotes = numberOfVotes + 1;
	}
}
