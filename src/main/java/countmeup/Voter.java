package countmeup;

/* Class Voter
 * Attributes: 	
 * 			Unique voter Id and the number of votes he has used. 
 * Methods:	
 * 			GetNumberofVotes - Getter for the number of votes.
 * 
 * 			canVote - Checks if the candidate can vote.
 * 				if he has voted three times, he can't vote any more.
 * 				
 * 			doVote - If the Voter can vote, it adds to the number he has
 * 				voted 
 */
public class Voter {
	private final int voterId;
	private int votesCasted;
	
	Voter (int id) {
		voterId = id;
		votesCasted = 0;
	}
	
	public int getNumberOfVotes () {
		return votesCasted;
	}
	
	public boolean canVote () {
		return  votesCasted < 3 ? true : false;
	}
	
	public boolean doVote () {
		if (canVote() ) {
			votesCasted++;
			return true;
		}
		
		return false;
	}
}
