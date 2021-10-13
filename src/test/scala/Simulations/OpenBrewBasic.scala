package Simulations

//import

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class OpenBrewBasic extends Simulation {

  //create http protocol configuration
  val httpProtocol = http.baseUrl("https://api.openbrewerydb.org")


  //create scenarios which will send http request
  val scn = scenario("find_scenarios")
            .exec(http("all_breweries").get("/breweries"))


  //inject loads
  setUp(scn.inject(atOnceUsers(2))).protocols(httpProtocol)


}
