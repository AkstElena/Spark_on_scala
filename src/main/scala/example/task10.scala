package example

import org.apache.spark.sql.SparkSession


//Задание 10: Сделайте фильтрацию по полю IsActive

// Не забыть поставить галочку в настройках конфигурации  Add dependencies with “provided” scope to classpath

object task10 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Task9").master("local[*]").getOrCreate()
    import spark.implicits._
    val data = Seq(
      ("John", 30, "1994-02-09", true),
      ("Mark", 29, "1995-03-13", false),
      ("Jane", 25, "1999-02-28", false),
      ("Meg", 35, "1989-05-28", true),
      ("Alex", 35, "1989-05-28", true)
    )

    val df = data.toDF("Name", "Age", "BirthDay", "IsActive")
    df.show()

    val filterIsActive = df.filter($"IsActive" === true)
    filterIsActive.show()

    val countIsActive = df.filter($"IsActive").count()  // счиате значения true
    println(countIsActive)

    spark.stop()

  }



}
