package example

//Задание 8: Функция для получения списка квадратов чисел

object task8 {

  def main(args: Array[String]): Unit = {

    def listSquares(myList: List[Int]) : List[Int] = myList.map(x => x * x)

    val numbers = List(2, 3, 5, 11)
    println(listSquares(numbers))

  }

}
