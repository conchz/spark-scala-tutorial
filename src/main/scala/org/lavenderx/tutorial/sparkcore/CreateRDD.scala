package org.lavenderx.tutorial.sparkcore

import org.lavenderx.tutorial.SparkConnector

object CreateRDD extends SparkConnector {

  def main(args: Array[String]) {
    // Create RDDs using parallelize() method of SparkContext
    val lines = sparkContext.parallelize(List("pandas", "i like pandas"))
    lines.collect().foreach(println)

    // Create RDDs is to load data from external storage
    val rddDataSet = sparkContext.textFile("src/main/resources/test_file.txt")
    rddDataSet.collect().foreach(println)
  }
}
