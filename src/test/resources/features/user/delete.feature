@user
Feature: Delete user

  @delete_user_by_id
  Scenario: Delete user by id

    Given there is users API

    When I delete user by id 1

    Then I should see response code is 204


