package ip

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import props.Params
/**
  * Created by yaron on 23/04/16.
  */
class ImageProcessor(clusterPort: Int) {

  private val conf = ConfigFactory.parseString(s"akka.remote.netty.tcp.port=$clusterPort")
    .withFallback(ConfigFactory.load("application.conf"))

  private val system = ActorSystem(Params.CLUSTER_NAME, conf)
  val ipActor = system.actorOf(Props[ImageProcessorActor], name = "ip-actor")

}
