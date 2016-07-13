package org.lavenderx.tutorial.spark.sql

import org.apache.spark.sql.functions._
import org.lavenderx.tutorial.spark.SparkConnector

object CSVDataSourceExample extends SparkConnector {
  def main(args: Array[String]) {
    val dataset = sparkSQLContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("src/main/resources/wholesale_customers_data.csv")

    dataset.show()
    dataset.printSchema()

    val aggregator = dataset.agg(max(dataset("Milk")), avg(dataset("Grocery")))

    sparkContext.stop()
  }
}
