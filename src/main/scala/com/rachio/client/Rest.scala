package com.rachio.scala.client

import akka.actor.ActorSystem

import scalaz._
import Scalaz._
import scala.concurrent._
import akka.util.Timeout

import scala.concurrent.duration._
import akka.io.IO
import akka.pattern.ask
import spray.can.Http
import spray.http._
import spray.client.pipelining._
import spray.httpx.SprayJsonSupport
import com.rachio.scala.client.types._

private object ClientStuffs {
  val version = "1"
}


trait ActorBase {
  implicit val system = ActorSystem("rachio-client")
  implicit val ex:ExecutionContext = system.dispatcher
  implicit val timeout:Timeout = 2.minutes
}

trait Driver {
  us: ActorBase =>
  import ClientStuffs._
  private var apiToken = "e77c81dc-c167-4ef7-97bd-1bf8f7144bc3"
  val host = s"api.rach.io"
  val base = s"/${version}/public"
  val pipeline: Future[SendReceive] = {
    for (
      Http.HostConnectorInfo(connector, _) <-
      IO(Http) ? Http.HostConnectorSetup(host, port = 443, sslEncryption = true)
    ) yield (
      addCredentials(OAuth2BearerToken(apiToken))
      ~> sendReceive(connector)
    )
  }

  def send(req:HttpRequest)(implicit ex:ExecutionContext) = {
    pipeline.flatMap(_(req))
  }

  val login = send(Get(s"$base/person/info"))
  login.onSuccess{
    case f:HttpResponse=>
      import RachioJsonProtocol._
      import SprayJsonSupport._
      println(f)
      val thebiz = unmarshal[PersonId]
      val person = send(Get(s"$base/person/${thebiz(f).id}"))
      person.onSuccess {
        case x:HttpResponse =>
          val otherbiz = unmarshal[Device]
          println(otherbiz(x))
      }

  }

  login.onFailure {
    case ex:Throwable =>
      println("we got fucked up", ex)
  }

}