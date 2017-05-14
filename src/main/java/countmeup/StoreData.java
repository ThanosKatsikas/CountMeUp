package countmeup;

import java.util.List;


/*
 *  Interface for managing data storage.
 *  This can later be implemented by a class that 
 *  works with a Redis Repo. 
 */
 
public interface StoreData{
	
	public void setVoter(int voterId);
	public Voter getVoter(int voterId);
	
	public void setCandidate (int candidateId);
	public Candidate getCandidate (int candidateId);

	public List<Candidate> getCandidates();
}
