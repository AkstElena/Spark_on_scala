package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

//Задание 12: Создадим второй датафрейм. Объедините citiesDF и df по полю Name
// Сделайте группировку по полю City, примените агрегирующую функцию count и сделайте сортировку desc по полю к которому вы сделали агрегацию

// Не забыть поставить галочку в настройках конфигурации  Add dependencies with “provided” scope to classpath

object task12 {

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
    //    df.show()

    val citiesData = Seq(
      ("John", "New York"),
      ("Mike", "Los Angeles"),
      ("Mark", "Boston"),
      ("Jane", "Boston"),
      ("Helen", "New York"),
      ("Meg", "New York"),
      ("Alex", "New York")
    )

    val citiesDf = citiesData.toDF("Name", "City")
    //    citiesDf.show()


    val joinedDF = df.join(citiesDf, Seq("Name"))
    joinedDF.show()

    val dfOnSity = joinedDF.groupBy("City").count().sort(desc("count"))
    dfOnSity.show()


    spark.stop()

  }


}
