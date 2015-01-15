/**
 * Created by xu on 2015/1/14.
 * 分析搜狗的查询日志统计汉字的出现频率
 */

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

import scala.collection.mutable.ArrayBuffer

class SogouAnalysis2 {

}

object SogouAnalysis2 {

  def main(args: Array[String]) {
    val sc = new SparkContext("local", "SogouAnalysis")
    val rdd = sc.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\SogouQ.reduced").map(_.split("\t")).map(x => (x(2)))
      .flatMap(x => (splitWords(x))).map(x => (x, 1)).reduceByKey(_ + _).filter(x => (x._2 > 50000)).map(x => (x._2, x._1)) sortByKey (false)
    rdd.foreach(println)
    sc.stop
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