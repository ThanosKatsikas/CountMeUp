package countmeup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VoterTest {

	Voter voter;
	
	/*
	 * Initializes a voter object before tests
	 */
	@Before
	public void testPrep ()  throws Exception {
		voter = new Voter(1);
	}
	
	/*
	 * Tests that the voter always has zero votes
	 * when a new voter instance is created. 
	 */
	@Test
	public void testGetNumberOfVotes() {			
		assertEquals(0,voter.getNumberOfVotes());
	}

	/*
	 * A voter can vote no more than three times
	 * regardless of who he votes for.
	 */
	@Test
	public void testCanVote() {
		voter.setVotes(2);
		// We should be able to vote if we have two votes.
		assert(voter.canVote());
		
		voter.setVotes(3);
		// But we shouldn't if we have three. 
		assert(!voter.canVote());
	}

	/*
	 * Voting should increase the votes count by one
	 */
	@Test
	public void testDoVote() {
		voter.doVote();
		
		assertEquals(voter.getNumberOfVotes(),1);
	}

	


}
