@user
Feature: Get user

  @get_single_user_by_id
  Scenario: Get Single User by id

    Given there is users API

    When I get single user by id 1

    Then I should see response code is 200
    And I should see the property "id" in the response by path "data.id"
