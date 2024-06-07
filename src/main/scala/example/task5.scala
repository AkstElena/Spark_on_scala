package example

//Задание 5: Фильтрация списка строк по длине

object task5 {

  def main(args: Array[String]): Unit = {


    val listString = Array("Один", "Два", "Три", "Четыре", "Пять", "Шесть")
    val filterStrings = listString.filter(_.length > 3)
    println(filterStrings.mkString(", "))

  }

}
