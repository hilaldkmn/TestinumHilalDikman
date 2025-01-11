import Utils.DriverManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/Feature"},
        //local rapor oluşturmak için aşağıdaki satır aktif edilebilir
        //plugin = {"pretty", "html:target/cucumber-reports"},
        glue={"Steps"},
        tags = "@all"
)


public class TestRunner{

}



