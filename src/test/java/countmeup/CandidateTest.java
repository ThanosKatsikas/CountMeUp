package countmeup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CandidateTest {
	Candidate candidate;

	/*
	 * Sets up a Candidate instance for the tests.
	 */
	@Before
	public void setUp() throws Exception {
		candidate = new Candidate(1);
	}

	/*
	 * Tests that a Candidate always starts with
	 * zero vote count.
	 */
	@Test
	public void testGetNumberOfVotes() {
		assertEquals (candidate.getNumberOfVotes(),0);
	}

	/*
	 * Tests that vote count is increased by one
	 * when adding a vote to the Candidate.
	 */
	@Test
	public void testAddVote() {
		candidate.addVote();
		
		assertEquals (candidate.getNumberOfVotes(),1);
	}

}
