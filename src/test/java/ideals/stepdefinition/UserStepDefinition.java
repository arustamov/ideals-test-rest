package ideals.stepdefinition;

import ideals.entity.User;
import ideals.enums.SessionVariable;
import ideals.step.CommonStep;
import ideals.step.UserStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Shared;

public class UserStepDefinition {

    @Shared
    private CommonStep commonStep;
    @Shared
    private UserStep userStep;

    @Given("there is users API")
    public void there_is_users_api() {
        SerenityRest.setDefaultBasePath("/api/users");
    }

    @When("I create user with name {string} and job {string}")
    public void i_create_user(String name, String job) {
        userStep.post(
            new User(name, job)
        );

        commonStep.setSessionVariable(SessionVariable.NAME, name);
        commonStep.setSessionVariable(SessionVariable.JOB, job);
    }

    @When("I get single user by id {int}")
    public void i_get_single_user_by_id(Integer id) {
        userStep.get(id);

        commonStep.setSessionVariable(SessionVariable.ID, id);
    }

    @When("I put update user with name {string} and job {string} by id {int}")
    public void i_put_update_user_with_name_and_job_by_id(String name, String job, Integer id) {
        userStep.put(
            id,
            new User(name, job)
        );

        commonStep.setSessionVariable(SessionVariable.NAME, name);
        commonStep.setSessionVariable(SessionVariable.JOB, job);
    }

    @When("I patch update user with name {string} and job {string} by id {int}")
    public void i_patch_update_user_by_id(String name, String job, Integer id) {
        userStep.patch(
            id,
            new User(name, job)
        );

        commonStep.setSessionVariable(SessionVariable.NAME, name);
        commonStep.setSessionVariable(SessionVariable.JOB, job);
    }

    @When("I delete user by id {int}")
    public void i_delete_user_by_id(Integer id) {
        userStep.delete(id);

        commonStep.setSessionVariable(SessionVariable.ID, id);
    }

    @Then("I should see response code is {int}")
    public void i_should_response_code_is(Integer responseCode) {
        userStep.verifyResponseStatusCode(responseCode);
    }

    @Then("I should see property {string} in the response by path {string}")
    public void i_should_see_property_in_the_response_by_path(String propertyName, String path) {
        final Object propertyValue = userStep.verifyResponseNotNull(path);

        commonStep.setSessionVariable(
            SessionVariable.from(propertyName),
            propertyValue
        );
    }

    @Then("I should see the property {string} in the response by path {string}")
    public void i_should_see_the_property_in_the_response_by_path(String propertyName, String path) {
        Object propertyValue = Serenity.sessionVariableCalled(
            SessionVariable.from(propertyName)
        );

        userStep.verifyResponsePath(
            path,
            propertyValue
        );

        commonStep.setSessionVariable(
            SessionVariable.from(propertyName),
            propertyValue
        );
    }
}
