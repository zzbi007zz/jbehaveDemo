Narrative:
  As an automation tester
  I want to search for "jbehave" on Google
  And validate the first result

Scenario: Search for jbehave on Google
  Given I open the Google homepage
  When I search for "jbehave" 
  Then the first result title contains "What is jBehave?"
  And if it does not contain "What is jBehave?"
  Then raise an error "First result did not contain expected title"
