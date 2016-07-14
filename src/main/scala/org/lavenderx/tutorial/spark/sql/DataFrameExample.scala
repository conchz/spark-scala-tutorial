package org.lavenderx.tutorial.spark.sql

import org.apache.spark.sql.functions._
import org.lavenderx.tutorial.spark.SparkConnector

object DataFrameExample extends SparkConnector {
  def main(args: Array[String]) {
    val employees = List(Employee(101, " huangmeiling  "), Employee(102, " sunbow  "), Employee(103, " json  "))

    // Create a DataFrame
    val dataset = sparkSQLContext.createDataFrame(employees)
    dataset.show()

    // Aggregate operations
    dataset.groupBy().agg(max(dataset("name")), avg(dataset("id"))).show()

    // String operations
    dataset.select(dataset("id"), trim(dataset("name"))).show()
    dataset.select(dataset("id"), split(dataset("name"), "o")).show()

    // Other operations
    dataset.select(cos(dataset("id")), dataset("id"), dataset("id") + 10, dataset("name").substr(0, 3)).show()
    dataset.select(max(dataset("id")), max(dataset("name"))).show()

    sparkContext.stop()
  }
}
