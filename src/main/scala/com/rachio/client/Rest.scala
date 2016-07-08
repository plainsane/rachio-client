package com.rachio.scala.client

import scalaz._
import Scalaz._
import scalaz.concurrent.Task
import akka.io.IO
import akka.pattern.ask
import spray.can.Http
import spray.http._
import spray.client.pipelining._

private object ClientStuffs {
  val version = "1"
}

case class Zone {
}

case class Device {

}

class Driver {
  import ClientStuffs._
  val base = s"https://api.rach.io/${version}/public"
}