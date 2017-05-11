package countmeup;

public class Voter {
	int voterId;
	int votesCasted;
	
	Voter (int id) {
		voterId = id;
		votesCasted = 0;
	}
	
	int getNumberOfVotes ()
	{
		return votesCasted;
	}
	
	boolean canVote () {
		
		return  votesCasted <= 3 ? true : false;
		
	}
	
	boolean doVote () {
		if (canVote() ) {
			votesCasted++;
			return true;
		}
		
		return false;
	}
}
