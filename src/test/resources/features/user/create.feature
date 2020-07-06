@user
Feature: Create user

  @create_user
  Scenario: Create User

    Given there is users API

    When I create user with name "Chuck" and job "QA"

    Then I should see response code is 201
    And I should see property "id" in the response by path "id"


