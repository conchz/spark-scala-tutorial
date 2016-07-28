package org.lavenderx.tutorial.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

trait SparkConnector {
  lazy val conf = {
    new SparkConf(false)
      .setMaster("spark://master:7077")
      .setAppName("Spark Tutorial")
  }

  lazy val sparkContext = new SparkContext(conf)
  lazy val sparkSQLContext = SparkSession.builder().config(conf).getOrCreate()
  lazy val sparkStreamingContext = StreamingContext.getActive()
    .getOrElse(new StreamingContext(sparkContext, Seconds(2)))
}
