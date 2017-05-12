package countmeup;

import java.util.List;

public interface StoreData{
	
	public void setVoter(int voterId);
	public Voter getVoter(int voterId);
	
	public void setCandidate (int candidateId);
	public Candidate getCandidate (int candidateId);

	public List<Candidate> getCandidates();
}
