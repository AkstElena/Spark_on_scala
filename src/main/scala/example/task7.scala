package example

//Задание 7: Объединение двух списков и их сортировка

object task7 {

  def main(args: Array[String]): Unit = {


    val list1 = List(3, 1, 4)
    val list2 = List(2, 5, 6)

    val joinLists = (list1 ++ list2).sorted
    println(joinLists)



  }

}
