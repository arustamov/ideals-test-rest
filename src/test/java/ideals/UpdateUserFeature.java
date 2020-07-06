package ideals;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report/user/update.json"},
    glue = "ideals.stepdefinition",
    features = "classpath:features/user/update.feature"
)
public class UpdateUserFeature {}
