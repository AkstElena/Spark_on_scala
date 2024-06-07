package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

//Задание 9: Создание DataFrame с различными типами данных
// сделайте группировку по полю IsActive и примените функцию avg к колонке Age

// Не забыть поставить галочку в настройках конфигурации  Add dependencies with “provided” scope to classpath

object task9 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Task9").master("local[*]").getOrCreate()
    import spark.implicits._
    val data = Seq(
      ("John", 30, "1994-02-09", true),
      ("Mark", 29, "1995-03-13", false),
      ("Jane", 25, "1999-02-28", false),
      ("Meg", 35, "1989-05-28", true)
    )

    val df = data.toDF("Name", "Age", "BirthDay", "IsActive")
//    df.collect.foreach(println) вывод построчно
    df.show()

    val avgAgeOnIsActiv = df.groupBy("IsActive").agg(avg("Age"))
    avgAgeOnIsActiv.show()

    spark.stop()

  }



}
