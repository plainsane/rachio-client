import akka.actor.ActorSystem
import com.rachio.scala.client.Driver

object Main extends App with Driver {
  implicit val system = ActorSystem("rachio-client")

}