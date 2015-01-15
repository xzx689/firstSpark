import org.apache.spark.SparkContext._
import org.apache.spark.SparkContext
import scala.collection.mutable.ArrayBuffer


/**
 * Created by xu on 2015/1/13.
 * 统计中文出现的次数
 */
class CountZhongWen {

}

object CountZhongWen {
  def main(args: Array[String]) {
    val str = "天生我才必有用，千金散尽还复来！" +
      "天才啊"
    val sc = new SparkContext("local", "CountZhongWen")
    val words: ArrayBuffer[Char] = splitWords(str)
    println(words.length)
    val rdd = sc.parallelize(words.toList.map((_,1)))
   val rdd2 = rdd.reduceByKey(_+_).map(x=>(x._2,x._1)).sortByKey(false)
    rdd2.foreach(println)
    sc.stop()
  }

  def splitWords(str: String): ArrayBuffer[Char] = {
    import scala.collection.mutable.ArrayBuffer
    var words = new ArrayBuffer[Char]()
    for (w <- str) {
      words += w
    }
    words
  }
}