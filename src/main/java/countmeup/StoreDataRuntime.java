package countmeup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Non persistent data storage during runtime. 
 * We use a hashmap to store the voters and the candidates.
 * We count each vote as it happens.
 */
public class StoreDataRuntime implements StoreData{
	
	private final HashMap<Integer, Candidate> candidateMap;
	private final HashMap<Integer, Voter> voterMap;
	
	StoreDataRuntime() {
		candidateMap = new HashMap<Integer,Candidate>();
		voterMap =new HashMap<Integer,Voter>();
	}


	@Override
	public void setVoter(int voterId) {
		voterMap.put(voterId, new Voter(voterId));
	}

	@Override
	public Voter getVoter(int voterId) {
			return voterMap.get(voterId);
		
	}

	@Override
	public void setCandidate(int candidateId) {
		candidateMap.put(candidateId, new Candidate(candidateId));
	}

	@Override
	public Candidate getCandidate(int candidateId) {
		return candidateMap.get(candidateId);
	}
	@Override
	public  List <Candidate> getCandidates () {
		List<Candidate> Candidates = new LinkedList<Candidate>();
		
		for (HashMap.Entry<Integer, Candidate> entry : candidateMap.entrySet()){
			Candidates.add(entry.getValue());
		}
		return Candidates;
	}

	
}
