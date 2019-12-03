import com.andyartz.adventofcode2019.Day1
import groovy.transform.NotYetImplemented
import spock.lang.Specification
import spock.lang.Unroll

class Day1Spec extends Specification {

    Day1 systemUnderTest = new Day1()

    @NotYetImplemented
    @Unroll
    void "should solve sample"() {
        expect:
        systemUnderTest.getRequiredFuel(input) == expected

        where:
        input  | expected
        12     | 2
        14     | 2
        1969   | 654
        100756 | 33583
    }

}
