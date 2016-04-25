import com.typesafe.scalalogging.slf4j.LazyLogging
import ip.ImageProcessor

/**
  * Created by yaron on 21/04/16.
  */
object Main extends App with LazyLogging {

  override def main(args: Array[String]) {

    logger.info("application started")

    val port:Int = if (args.isEmpty) 0 else args(0).toInt

    Runner.run(port)

//    ip1.ipActor ! "start"

  }

}

/**
  * General cluster runner object
  */
object Runner {
  def run(port: Int): ImageProcessor = {
    new ImageProcessor(port)
  }
}
