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

    void "should solve puzzle part 1"() {
        expect:
        systemUnderTest.getNumberOfPasswords((265275..781584)) == 960
    }

    @Unroll
    void "should find number of passwords with stricter requirements in range"() {
        expect:
        systemUnderTest.getNumberOfPasswordsStrict((265275..end)) == expected

        where:
        end    | expected
        266665 | 0
        266666 | 0
        266677 | 1
    }

    void "should solve puzzle part 2"() {
        expect:
        systemUnderTest.getNumberOfPasswordsStrict((265275..781584)) == 626
    }
}
