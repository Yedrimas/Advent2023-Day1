
case object main extends App:

    val allowedChars = (0 to 9).map(c => ('0' + c).toChar).toList

    println(
        scala
          .io
          .Source
          .fromInputStream(getClass.getResourceAsStream("input.txt"))
          .mkString
          .split("\n")
          .map(_.filter(c => allowedChars.contains(c)))
          .map(_.map(_ - '0'))
          .map {
              line => line.head * 10 + line.last
          }
          .sum
    )




