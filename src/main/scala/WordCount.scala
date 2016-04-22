import org.apache.spark.{SparkConf, SparkContext}

/**
* Created by yaron on 22/04/16.
*/

object SparkWordCount {
  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf().setAppName("Spark WordCount"))

    val threshold = 3

    // split each document into words
    val tokenized = sc.textFile(args(0)).flatMap(_.split(" "))

    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)

    // filter out words with less than threshold occurrences
    val filtered = wordCounts.filter(_._2 >= threshold)

    System.out.println(filtered.collect().mkString(", "))
  }

}
