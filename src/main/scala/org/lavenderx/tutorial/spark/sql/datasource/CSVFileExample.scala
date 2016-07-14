package org.lavenderx.tutorial.spark.sql.datasource

import org.apache.spark.sql.functions._
import org.lavenderx.tutorial.spark.SparkConnector

object CSVFileExample extends SparkConnector {
  def main(args: Array[String]) {
    val dataset = sparkSQLContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("src/main/resources/wholesale_customers_data.csv")

    dataset.show()
    dataset.printSchema()

    dataset.agg(max(dataset("Milk")), avg(dataset("Grocery"))).show()

    sparkContext.stop()
  }
}
