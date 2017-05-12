package countmeup;

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
	int candidateId;
	int numberOfVotes;
	
	Candidate (int id) {
		candidateId = id;
		numberOfVotes = 0;
	}
	
	int getNumberOfVotes() {
		return numberOfVotes;
	}
	
	void addVote () {
		numberOfVotes = numberOfVotes + 1;
	}
}
