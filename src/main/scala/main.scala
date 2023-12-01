
case object main:

    private val converter = Map(
        "one" -> "1",
        "two" -> "2",
        "three" -> "3",
        "four" -> "4",
        "five" -> "5",
        "six" -> "6",
        "seven" -> "7",
        "eight" -> "8",
        "nine" -> "9",
    )

    // Part 2
    def replaceStringDigitToDigit(input: String): String =
    // Actually we need to be smart, we need to take the string from left to write
    // And event smarter, overlapping...
        if input.nonEmpty then
            // Get all substring
            val subStrings = input.inits.toList

            // Keep only substring that does matching something
            val matching = subStrings.filter(converter.keySet.contains)

            val firstChar =
                matching match
                    case head :: _ =>
                        // We found something !
                        val foundItem = converter(head)
                        // Gather the result, set it on the string
                        f"$foundItem"

                    case nil =>
                        f"${input.head.toString}"

            // call on the remaining string, head replaced with the match (or preserved if no match was found)
            f"$firstChar${replaceStringDigitToDigit(input.tail)}"
        else
            ""

    def filterNonDigits(input: String): String =
        input.filter(_.isDigit)

    // Will fail if called without `filterNonDigits`, its ok
    def convertToNum(input: String): Int =
        val minuses = input.map(_ - '0')
        minuses.head * 10 + minuses.last

    def compute(input: Iterable[String]): Int =
        input
          // Remove me for Part 1
          .map(replaceStringDigitToDigit)
          .map(filterNonDigits)
          .map(convertToNum)
          .sum

    def main(args: Array[String]): Unit =
        println(compute(scala
          .io
          .Source
          .fromInputStream(getClass.getResourceAsStream("input.txt"))
          .mkString
          .split("\n")))
