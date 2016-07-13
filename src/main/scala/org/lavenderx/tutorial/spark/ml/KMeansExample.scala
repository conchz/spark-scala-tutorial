package org.lavenderx.tutorial.spark.ml

import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.sql.DataFrame
import org.lavenderx.tutorial.spark.SparkConnector

object KMeansExample extends SparkConnector {
  def main(args: Array[String]) {
    // $example on$
    // Crates a DataFrame
    val dataset: DataFrame = sparkSQLContext.createDataFrame(Seq(
      (1, Vectors.dense(0.0, 0.0, 0.0)),
      (2, Vectors.dense(1.1, 4.5, 0.3)),
      (3, Vectors.dense(0.2, 0.2, 0.2)),
      (4, Vectors.dense(9.0, 9.0, 9.0)),
      (5, Vectors.dense(9.1, 0.8, 9.1)),
      (6, Vectors.dense(9.2, 1.2, 6.2)),
      (7, Vectors.dense(3.5, 6.2, 7.2)),
      (8, Vectors.dense(7.2, 9.2, 5.8)),
      (9, Vectors.dense(5.6, 4.4, 9.2)),
      (10, Vectors.dense(4.9, 8.6, 2.9))
    )).toDF("id", "features")

    // Trains a k-means model
    val kmeans = new KMeans()
      .setK(3)
      .setFeaturesCol("features")
      .setPredictionCol("prediction")
    val model = kmeans.fit(dataset)

    // Shows the result
    println("Final Centers: ")
    model.clusterCenters.foreach(println)

    // $example off$
    sparkContext.stop()
  }
}
