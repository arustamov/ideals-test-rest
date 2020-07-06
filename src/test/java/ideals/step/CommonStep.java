package ideals.step;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class CommonStep {

    @Step
    public void setSessionVariable(Object variableName, Object variableValue) {
        Serenity.setSessionVariable(variableName).to(variableValue);
    }
}
