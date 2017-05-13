package countmeup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class PollTest {
	Poll poll;
	
	@Before
	public void setUp() throws Exception {
		poll = new Poll(2);
	}

	/*
	 * Tests that casting a vote works as expected
	 */
	@Test
	public void testCastVote() {
		Voter voter = new Voter(1);
		// Cast a vote from voterId 1 to Candidate 1.
		poll.castVote(voter.getVoterId(), 1);
		
		//Check that Voter was stored.
		assertEquals(poll.getStoreData().getVoter(1).getVoterId(), voter.getVoterId());
		
		//Check that the Voter voted once
		assertEquals(poll.getStoreData().getVoter(1).getNumberOfVotes(), 1);
		

		//Test that the Candidate got one vote
		assertEquals(poll.getStoreData().getCandidate(1).getNumberOfVotes(), 1);
	}

	/*
	 * Confirms that votes are counted as expected
	 */
	@Test
	public void testGetResults() {
		List<Candidate> candidates = new LinkedList<Candidate>();
		// We will add four votes to Candidate 1
		// and two votes for Candidate 2
		poll.castVote(1, 1);
		poll.castVote(2, 1);
		poll.castVote(1, 1);
		poll.castVote(1, 1);
		poll.castVote(3, 2);
		poll.castVote(3, 2);
		// Voter 1 shouldn't be able to vote again
		poll.castVote(1, 1);
		
		candidates = poll.getResults();
		
		assertEquals(candidates.get(0).getNumberOfVotes(),4);
		assertEquals(candidates.get(1).getNumberOfVotes(),2);
	}

}
