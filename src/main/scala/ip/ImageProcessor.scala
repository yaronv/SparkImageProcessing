package ip

import com.typesafe.scalalogging.slf4j.LazyLogging
import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

/**
  * Created by yaron on 21/04/16.
  */
class ImageProcessor extends LazyLogging {

  def start() = {
    logger.info("image processor started")

    readAndProcess("/home/yaron/SampleImages/img.jpg", "/home/yaron/SampleImages/test.jpg")

    logger.info("image processor ended")
  }

  def process(img: BufferedImage): BufferedImage = {
    // obtain width and height of image
    val w = img.getWidth
    val h = img.getHeight

    // create new image of the same size
    val out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    // copy pixels (mirror horizontally)
    for (x <- 0 until w)
      for (y <- 0 until h)
        out.setRGB(x, y, img.getRGB(w - x - 1, y) & 0xffffff)

    // draw red diagonal line
    for (x <- 0 until (h min w))
      out.setRGB(x, x, 0xff0000)

    out
  }

  def readAndProcess(source: String, dest: String) {
    // read original image, and obtain width and height
    val photo1 = ImageIO.read(new File(source))

    val photo2 = process(photo1)

    // save image to file
    ImageIO.write(photo2, "jpg", new File(dest))
  }


}
