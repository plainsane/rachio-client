package com.rachio.client

import scalaz._
import Scalaz._
import scalaz.concurrent.Task
import play.api.libs.ws.ahc.AhcWSClient

private object ClientStuffs {
  type RClient = AhcWSClient
  val version = "1"
}

trait Zone {
  import ClientStuffs.RClient  
}

trait Schedule {
  import ClientStuffs.RClient  
  
}

trait Device {
  import ClientStuffs.RClient  
  
}

class Driver {
  import ClientStuffs._
  val base = s"https://api.rach.io/${version}/public"
  implicit val client = AhcWSClient()
  client.
}