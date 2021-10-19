package Simulations

//import

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt

class OpenBrewBasic extends Simulation {

  /* Place for arbitrary Scala code that is to be executed before the simulation begins. */
  before {
    println("\n\n***** My simulation is about to begin! *****\n\n")
  }

  /* Place for arbitrary Scala code that is to be executed after the simulation has ended. */
  after {
    println("\n\n***** My simulation has ended! ******\n\n")
  }



  //create http protocol configuration
  val httpProtocol = http.baseUrl("https://api.openbrewerydb.org")


  //create scenarios which will send http request
  val scn = scenario("find_scenarios")
            .exec(http("all_breweries").get("/breweries"))
            .pause(5.seconds)
            .exec(http("get_single_breweries").get("/breweries/boulder-beer-co-boulder"))


  //inject loads
  setUp(scn.inject(atOnceUsers(2))).protocols(httpProtocol)


}
