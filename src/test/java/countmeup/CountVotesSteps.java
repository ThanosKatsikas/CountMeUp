package countmeup;

import static org.junit.Assert.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CountVotesSteps {

	/*
	 * Ideally this should make proper requests
	 * to the Count Me Up application.
	 * However I will be abstracting the Spring part 
	 * and use only my model in the following tests and
	 * hopefully write proper ones in the next iteration.
	 * 
	 * Given I am count me up means that the Count me up 
	 * service has set one Poll. 
	 * 
	 * The return Code 201 means that poll.castVote returns true.
	 * The return Code 403 means that either the user can't cast
	 * another vote or that the candidate was invalid, which 
	 * translates in poll.castVote returning false. 
	 * 
	 */
	Poll poll;
	boolean response;
	int votesCountBefore;
	int votesCountAfter;
 
	@Given("^I am count me up$")
	public void i_am_count_me_up() {
		poll = new Poll(4);
	}
 
	@When("^voter (\\d+) has not voted before$")
	public void has_not_voted_yet(final int voterId) {
		assertEquals(poll.getStoreData().getVoter(voterId), null);
	}
	
	@And("^I have received (\\d+) votes for candidate (\\d+) from voter (\\d+)$")
	public void have_received_X_votes_for(final int numberOfVotes, final int candidateId, final int voterId) {
		for (int i = 0; i< numberOfVotes;i++) { 
			poll.castVote(voterId, candidateId);
		}
		votesCountBefore = poll.getStoreData().getCandidate(candidateId).getNumberOfVotes();
	}
	
	@And("^I receive a vote for candidate (\\d+) from voter (\\d+)$")
	public void receive_a_vote_for(final int candidateId, final int voterId) {
		response = poll.castVote(voterId, candidateId);
		
		votesCountAfter = poll.getStoreData().getCandidate(candidateId).getNumberOfVotes();
	}
 
	@Then("^I register that vote and return a (\\d+) response$")
	public void register_vote_and_response(final int code) {
		assertEquals(response, errorCode(code));
	}
	
	@Then("^I return a (\\d+) response$")
	public void return_response(final int code) {
		assertEquals(response, errorCode(code));
	}
	
	@Then("^I do not register that vote$")
	public void do_not_register_vote() {
		assertEquals(votesCountBefore, votesCountAfter);
	}
	 
	public boolean errorCode (int code) {
		switch (code) {
		case 201:
			return true;
		case 403:
			return false;
		}
		return false;
	}
}
