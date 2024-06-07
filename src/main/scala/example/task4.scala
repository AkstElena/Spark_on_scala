package example
//Задание 4: Создайте класс "Круг" с методом для вычисления площади

object task4 {

  def main(args: Array[String]): Unit = {


    class MyСircle (radius: Double) {

      def areaCircle = radius * radius * math.Pi

    }

    val myCircle = new MyСircle(10.2)
    println(myCircle.areaCircle)

  }

}
