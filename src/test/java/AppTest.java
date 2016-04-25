import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Parcel Calculator");
  }

  @Test
  public void isAValidInput() {
    goTo("http://localhost:4567");
    fill("#widthInput").with("5");
    fill("#depthInput").with("5");
    fill("#heightInput").with("5");
    fill("#weightInput").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("75");
  }
}
