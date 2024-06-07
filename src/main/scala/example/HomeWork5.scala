package example

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

// Не забыть поставить галочку в настройках конфигурации  Add dependencies with “provided” scope to classpath

object HomeWork5 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Task9").master("local[*]").getOrCreate()
    import spark.implicits._

    //— Используя Spark прочитайте данные из файла csv.
    val df = spark.read.format("csv").option("header", "true").option("inferSchema", "true")
      .load("C:\\Elena\\GeekBrains\\SparkOnScala\\Spark_on_scala\\src\\main\\scala\\example\\HW5.csv")
    //    df.show()

    val newDf = df.selectExpr(
      "title",
      "author",
      "genre",
      "sales",
      "cast(year as int) year")
    newDf.show()


    //— Фильтруйте данные, чтобы оставить только книги, продажи которых превышают 3000 экземпляров.
    val salesMore3000 = newDf.filter($"sales" > 3000)
    salesMore3000.show()

    //— Сгруппируйте данные по жанру и вычислите общий объем продаж для каждого жанра.
    //— Отсортируйте данные по общему объему продаж в порядке убывания.
    val groupGenre = newDf.groupBy($"genre").agg(sum($"sales") as "sumSales").sort(desc("sumSales"))

    //— Выведите результаты на экран.
    groupGenre.show()

    spark.stop()
  }

}
