import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/features/CodingTest.feature"},
        glue = {"stepDefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

