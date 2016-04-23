import akka.actor.{ActorSystem, Props}
import com.typesafe.scalalogging.slf4j.LazyLogging
import ip.ImageProcessor

/**
  * Created by yaron on 21/04/16.
  */
object Main extends App with LazyLogging {

  override def main(args: Array[String]) {

    logger.info("application started")

    val system = ActorSystem("HelloSystem")

    val ipActor = system.actorOf(Props[ImageProcessor], name = "ip-actor")

    ipActor ! "start"
  }

}
