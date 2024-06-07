package example
//Задание 2: Вывод четных чисел из списка от 1 до 10

object task2 {

  def main(args: Array[String]): Unit = {

    val numbers = (1 to 10).filter(_ % 2 == 0)

    println(numbers)
  }

}
