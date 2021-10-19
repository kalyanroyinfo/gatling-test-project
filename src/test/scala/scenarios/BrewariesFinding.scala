package scenarios

import io.gatling.core.Predef._
import requests.AllBreweriesRequest.allbreweries

object BrewariesFinding {
  val findBreweries = scenario("Search ALl Breweries")
    .exec(allbreweries)
    .exec{
      session=>
        println("**********Printing Response***********")
        println(session("all_breweries_response").as[String])
        session
    }

}
