package org.lavenderx.tutorial.spark

import org.apache.spark.sql.SQLContext
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

trait SparkConnector {
  lazy val conf = {
    new SparkConf(false)
      .setMaster("local[4]")
      .setAppName("Spark Tutorial")
  }

  lazy val sparkContext = new SparkContext(conf)
  lazy val sparkSQLContext = SQLContext.getOrCreate(sparkContext)
  lazy val streamingContext = StreamingContext.getActive()
    .getOrElse(new StreamingContext(sparkContext, Seconds(2)))
}
