
import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args){
    String layout = "templates/layout.vtl";

    get("/", (req,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request,res) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Integer widthInput = Integer.parseInt(request.queryParams("widthInput"));
      Integer depthInput = Integer.parseInt(request.queryParams("depthInput"));
      Integer heightInput = Integer.parseInt(request.queryParams("heightInput"));
      Integer weightInput = Integer.parseInt(request.queryParams("weightInput"));

      Parcel newParcel = new Parcel(widthInput, depthInput, heightInput, weightInput);
      String volume = newParcel.volume();
      String costToShip = newParcel.costToShip();

      model.put("costToShip", costToShip);
      model.put("volume", volume);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
