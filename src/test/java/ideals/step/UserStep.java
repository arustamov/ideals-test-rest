package ideals.step;

import ideals.enums.Endpoints;
import ideals.entity.User;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

public class UserStep {

    private EnvironmentVariables environmentVariables;

    @Step
    public void post(final User user) {
        SerenityRest
            .given()
            .baseUri(
                environmentVariables.getProperty("restapi.baseurl")
            )
            .basePath(Endpoints.USERS.getUrl())
            .contentType(ContentType.JSON)
            .body(user)
            .when()
            .post();
    }

    @Step
    public void get(final Integer id) {
        SerenityRest
            .given()
            .baseUri(
                environmentVariables.getProperty("restapi.baseurl")
            )
            .basePath(Endpoints.USER_BY_ID.getUrl())
            .pathParam("id", id)
            .get();
    }

    @Step
    public void put(final Integer id, final User user) {
        SerenityRest
            .given()
            .baseUri(
                environmentVariables.getProperty("restapi.baseurl")
            )
            .basePath(Endpoints.USER_BY_ID.getUrl())
            .contentType(ContentType.JSON)
            .pathParam("id", id)
            .body(user)
            .put();
    }

    @Step
    public void patch(final Integer id, final User user) {
        SerenityRest
            .given()
            .baseUri(
                environmentVariables.getProperty("restapi.baseurl")
            )
            .basePath(Endpoints.USER_BY_ID.getUrl())
            .contentType(ContentType.JSON)
            .pathParam("id", id)
            .body(user)
            .patch();
    }

    @Step
    public void delete(final Integer id) {
        SerenityRest
            .given()
            .baseUri(
                environmentVariables.getProperty("restapi.baseurl")
            )
            .basePath(Endpoints.USER_BY_ID.getUrl())
            .pathParam("id", id)
            .delete();
    }

    @Step
    public <T> T verifyResponseNotNull(String path) {
        return SerenityRest
            .then()
            .body(
                path,
                Matchers.notNullValue()
            )
            .extract()
            .path(path);
    }

    @Step
    public void verifyResponsePath(String path, Object value) {
        SerenityRest
            .then()
            .body(
                path,
                Matchers.is(value)
            );
    }

    @Step
    public void verifyResponseStatusCode(final Integer statusCode) {
        SerenityRest
            .then()
            .statusCode(statusCode);
    }
}
