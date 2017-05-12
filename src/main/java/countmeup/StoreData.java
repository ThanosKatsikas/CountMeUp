package countmeup;

public interface StoreData {
	
	void setVoter(int voterId);
	Voter getVoter(int voterId);
	
	void setCandidate (int candidateId);
	Candidate getCandidate (int candidateId);

	
}
