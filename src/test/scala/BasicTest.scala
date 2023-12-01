import main.filterNonDigits
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.*

class BasicTest extends AnyFunSpec with Matchers {

    val input =
        """two1nine
          |eightwothree
          |abcone2threexyz
          |xtwone3four
          |4nineeightseven2
          |zoneight234
          |7pqrstsixteen"""
          .stripMargin
          .split("\n")


    describe("Part2"):

        it("Should be [29, 83, 13, 24, 42, 14, 76]"):
            input
              .map(main.replaceStringDigitToDigit)
              .map(main.filterNonDigits)
              .map(main.convertToNum).toList shouldEqual List(29, 83, 13, 24, 42, 14, 76)

        it("Shouldb output 49"):
            Seq("four289")
              .map(main.replaceStringDigitToDigit)
              .map(main.filterNonDigits)
              .map(main.convertToNum).toList shouldEqual List(49)

        it("Shouldb output 28"):
            Seq("2oneight")
              .map(main.replaceStringDigitToDigit)
              .map(main.filterNonDigits)
              .map(main.convertToNum).toList shouldEqual List(28)

        it("Should output 281"):
            main.compute(input) shouldEqual 281


}
