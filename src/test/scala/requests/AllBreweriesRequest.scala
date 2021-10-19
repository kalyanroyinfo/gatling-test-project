package requests
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import config.Config
object AllBreweriesRequest {
  val allbreweries=http("all_breweries")
    .get(Config.app_url.concat("/breweries"))
    .check(status.is(200))
    .check(bodyString.saveAs("all_breweries_response"))
}
