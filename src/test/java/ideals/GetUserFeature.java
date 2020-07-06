package ideals;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report/user/get.json"},
    glue = "ideals.stepdefinition",
    features = "classpath:features/user/get.feature"
)
public class GetUserFeature {}
