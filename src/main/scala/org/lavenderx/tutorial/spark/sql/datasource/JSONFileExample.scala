package org.lavenderx.tutorial.spark.sql.datasource

import org.apache.spark.sql.DataFrame
import org.lavenderx.tutorial.spark.SparkConnector

object JSONFileExample extends SparkConnector {
  def main(args: Array[String]) {
    val dataset: DataFrame = sparkSQLContext.read
      .format("json")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("src/main/resources/cars.json")

    dataset.show()
    dataset.printSchema()

    dataset.select("name").show()
    dataset.filter(dataset("speed") > 300).show()
    dataset.groupBy("speed").count().show()

    sparkContext.stop()
  }
}
