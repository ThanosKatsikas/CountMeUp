Feature: counting votes
As a BBC television presenter
I want to see the counts for candidates within a given time frame
So that I can announce the winner of the competition

Scenario: Count Me Up accepts a vote
Given I am count me up
When I receive a vote for candidate A from voter A
And voter A has not voted before
Then I register that vote and return a 201 response
