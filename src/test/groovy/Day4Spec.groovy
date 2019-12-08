import spock.lang.Specification
import spock.lang.Unroll

class Day4Spec extends Specification {

    Day4 systemUnderTest = new Day4()

    @Unroll
    void "should find number of passwords in range"() {
        expect:
        systemUnderTest.getNumberOfPasswords((265275..end)) == expected

        where:
        end    | expected
        266665 | 0
        266666 | 1
    }

    void "should solve day 1 puzzle"() {
        expect:
        systemUnderTest.getNumberOfPasswords((265275..781584)) == 960
    }
}
