import com.typesafe.scalalogging.slf4j.LazyLogging
import ip.ImageProcessor

/**
  * Created by yaron on 21/04/16.
  */
object Main extends App with LazyLogging {

  override def main(args: Array[String]) {

    logger.info("application started")

    Runner.run(2551)

  }

}

/**
  * General cluster runner object
  */
object Runner {
  def run(port: Int): Unit = {
    new ImageProcessor(port)
  }
}
