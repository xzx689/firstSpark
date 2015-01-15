
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by xu on 2014/12/24.
 */
class SprakRDD {

}

object SparkRDD {

  def main(args: Array[String]): Unit = {
    println("-------------------------start----------------------")
    //rdd2.filter(_(3).toInt==1).filter(_(4).toInt==1).map(_(1)).foreach(println)
    val conf = new SparkConf().setAppName("SparkFist")
    // conf.setMaster("spark://xu:7077")
    val spark = new SparkContext("local", "SparkFist")
    //val rdd = spark.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\test.txt").map(_.split(" ")).map(x => (x(0), x(2).toInt)).reduceByKey(_ + _)
    //val rdd = spark.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\test.txt").map(_.split(" "))
    //val rdd = spark.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\test.txt").map(line=>line.split(" ")).map(x=>(x(0),x(2)))
    val rdd = spark.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\test.txt").flatMap(line=>line.split(" "))

    //val rdd2 = spark.textFile("C:\\Users\\xu\\Desktop\\SogouQ.reduced\\test.txt").flatMap(_.split(" "))
    rdd.foreach(println)
    //rdd2.foreach(println)
    //val rdd2 =rdd.map(_.split("\t")).map(x>=(x(0),x(2))).reduceByKey(_+_)


    // val wordcount = rdd.flatMap(_.split(' ')).map((_,1)).reduceByKey(_+_)

    //val wordcount = rdd.flatMap(_.split(' ')).map((_,1)).reduce()
    //rdd.collect


    println("-------------------------end----------------------")
    spark.stop()


  }

}