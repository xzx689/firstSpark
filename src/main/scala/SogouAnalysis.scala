/**
 * Created by xu on 2015/1/13.
 * 分析搜狗的查询日志统计汉字的出现频率
 */

import org.apache.spark.SparkContext

import scala.collection.mutable.ArrayBuffer

class SogouAnalysis {

}

object SogouAnalysis {
  def main(args: Array[String]) {

    val sc = new SparkContext("local[4]", "SogouAnalysis")
    //val rdd = sc.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\sg.txt").map(_.split("\t")).map(x => (x(2)))
    val wordss = new ArrayBuffer[Char]()
    val list = scala.collection.mutable.ListBuffer[Char]()
    val rdd = sc.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\sg.txt").map(_.split("\t")).map(x => splitWords(x(2)).map(x => ((x))))

    val rdd2 = rdd.map(x => (x)).map(x => for (i <- 0 until x.length) {
      // println(x(i))
      // wordss += x(i)
      //.reduceByKey(_+_)
      //wordss += x(i)
      //list.append(x(i))

    })
    list.foreach(println)

    rdd2.foreach(println)
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