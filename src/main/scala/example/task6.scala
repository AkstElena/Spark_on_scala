package example

//Задание 6: Рекурсивная функция для вычисления факториала

object task6 {

  def main(args: Array[String]): Unit = {

    def factorialMy(number: Int): Int = {
      if (number <= 1) 1
      else number * factorialMy(number-1)
    }

    println(factorialMy(5))

  }

}
