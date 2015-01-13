import org.apache.spark.SparkContext
import scala.math.random
/**
 * Created by xu on 2015/1/13.
 */
class SparkPI {

}

object SparkPI {
  def main(args: Array[String]) {
    val spark = new SparkContext("local", "sparkPI")
    val count = spark.parallelize(1 to 100000, 2).map { _ =>
      val x = random * 2 - 1
      val y = random * 2 - 1
      if (x * x + y * y < 1) 1 else 0
    }.reduce(_ + _)
    println("Pi is roughly" + 4.0 * count / 100000)
    spark.stop()
  }

}