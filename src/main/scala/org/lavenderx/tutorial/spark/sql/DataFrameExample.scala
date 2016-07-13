package org.lavenderx.tutorial.spark.sql

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.lavenderx.tutorial.spark.SparkConnector

object DataFrameExample extends SparkConnector {
  def main(args: Array[String]) {
    val employees = List(Employee(101, " huangmeiling  "), Employee(102, " sunbow  "), Employee(103, " json  "))

    // Create a DataFrame
    val dataset: DataFrame = sparkSQLContext.createDataFrame(employees)
    dataset.show()

    // Aggregate operations
    val aggregator = dataset.groupBy().agg(max(dataset("name")), avg(dataset("id")))

    // String operations
    val str1 = dataset.select(dataset("id"), trim(dataset("name")))
    val str2 = dataset.select(dataset("id"), split(dataset("name"), "o"))

    // Other operations
    val out1 = dataset.select(cos(dataset("id")), dataset("id"), dataset("id") + 10, dataset("name").substr(0, 3))
    val out2 = dataset.select(max(dataset("id")), max(dataset("name")))

    sparkContext.stop()
  }
}
