@users
Feature: Update user

  @put_user
  Scenario: Update user PUT

    Given there is users API

    When I put update user with name "Norris" and job "Manual QA" by id 1

    Then I should see response code is 200
    And I should see the property "name" in the response by path "name"
    And I should see the property "job" in the response by path "job"

  @patch_user
  Scenario: Update user PATCH

    Given there is users API

    When I patch update user with name "Norris" and job "Automation QA" by id 1

    Then I should see response code is 200
    And I should see the property "name" in the response by path "name"
    And I should see the property "job" in the response by path "job"
