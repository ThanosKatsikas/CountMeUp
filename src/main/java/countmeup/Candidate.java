package countmeup;

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
	
	void voteFor () {
		numberOfVotes = numberOfVotes + 1;
	}
}
