package Simulations

import io.gatling.core.Predef._
import scenarios.BrewariesFinding

//import scala.concurrent.duration.DurationInt

class BrewDivideScenarios extends Simulation{
  val httpConf=BrewariesFinding.findBreweries.inject(atOnceUsers(1))

  setUp(httpConf)
}
