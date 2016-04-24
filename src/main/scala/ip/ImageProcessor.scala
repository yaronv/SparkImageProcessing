package ip

import akka.actor.{ActorSystem, PoisonPill, Props}
import com.typesafe.config.ConfigFactory
import props.Params
/**
  * Created by yaron on 23/04/16.
  */
class ImageProcessor(clusterPort: Int) {

  val conf = ConfigFactory.parseString(s"akka.remote.netty.tcp.port=$clusterPort")
    .withFallback(ConfigFactory.load("application.conf"))

  val system = ActorSystem(Params.CLUSTER_NAME)
  val ipActor = system.actorOf(Props[ImageProcessorActor], name = "ip-actor")

  ipActor ! "start"
}
