import com.typesafe.scalalogging.slf4j.LazyLogging
import ip.ImageProcessor

/**
  * Created by yaron on 21/04/16.
  */
object Main extends LazyLogging {

  def main(args: Array[String]) {

    logger.info("application started")

    val ip = new ImageProcessor()

    ip.start()

    logger.info("application ended")
  }

}
