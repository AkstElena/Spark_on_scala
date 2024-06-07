package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

//Задание 11: Сделайте фильтрацию по полю IsActive

// Не забыть поставить галочку в настройках конфигурации  Add dependencies with “provided” scope to classpath

object task11 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Task9").master("local[*]").getOrCreate()
    import spark.implicits._
    val data = Seq(
      ("John", 30, "1994-02-09", true),
      ("Mike", 10, "2014-01-21", true),
      ("Mark", 29, "1995-03-13", false),
      ("Jane", 25, "1999-02-28", false),
      ("Helen", 5, "2019-04-01", false),
      ("Meg", 35, "1989-05-28", true),
      ("Alex", 35, "1989-05-28", true)
    )

    val df = data.toDF("Name", "Age", "BirthDay", "IsActive")
    df.show()

//    val dfWithSortAge = df.withColumn("adult", when($"Age" >= 18, true).otherwise(false))
    val dfWithSortAge = df.withColumn("adult", $"Age" >= 18)
    dfWithSortAge.show()


    spark.stop()

  }



}
