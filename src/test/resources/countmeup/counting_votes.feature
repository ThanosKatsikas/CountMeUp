Feature: counting votes
 As a BBC television presenter
 I want to see the counts for candidates within a given time frame
 So that I can announce the winner of the competition


Scenario: Count Me Up only accepts 3 votes per user
 Given I am count me up
  And I have received 3 votes for candidate 1 from voter 2
 When I receive a vote for candidate 1 from voter 2
  Then I return a 403 response
   And I do not register that vote

Scenario: Count Me Up accepts a vote
 Given I am count me up
 When voter 1 has not voted before
  And I receive a vote for candidate 1 from voter 1
 Then I register that vote and return a 201 response

Scenario: Count Me Up only accepts 3 votes per user regardless of candidate
 Given I am count me up
  And I have received 2 votes for candidate 1 from voter 2
  And I have received 1 vote for candidate 4 from voter 2
 When I receive a vote for candidate 4 from voter 2
 Then I return a 403 response
  And I do not register that vote
