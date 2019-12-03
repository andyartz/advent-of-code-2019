import spock.lang.Specification
import spock.lang.Unroll

class Day1Spec extends Specification {

    Day1 systemUnderTest = new Day1()

    @Unroll
    void "should solve for mass #mass"() {
        expect:
        systemUnderTest.getRequiredFuel(mass) == expectedFuel

        where:
        mass   | expectedFuel
        12     | 2
        14     | 2
        1969   | 654
        100756 | 33583
    }

    void "should solve for a list of masses"() {
        expect:
        systemUnderTest.getRequiredFuel([12, 14, 1969, 100756]) == 2 + 2 + 654 + 33583
    }

    void "should solve part 1 puzzle"() {
        given:
        List<Integer> masses = getClass().getResource('day1.txt').readLines()*.toInteger()

        expect:
        systemUnderTest.getRequiredFuel(masses) == 3324332
    }

    @Unroll
    void "should solve total fuel required for mass #mass"() {
        expect:
        systemUnderTest.getAllRequiredFuel(mass) == expectedFuel

        where:
        mass   | expectedFuel
        12     | 2
        14     | 2
        1969   | 966
        100756 | 50346
    }

    void "should solve total fuel for a list of masses"() {
        expect:
        systemUnderTest.getAllRequiredFuel([12, 14, 1969, 100756]) == 2 + 2 + 966 + 50346
    }

    void "should solve part 2 puzzle"() {
        given:
        List<Integer> masses = getClass().getResource('day1.txt').readLines()*.toInteger()

        expect:
        systemUnderTest.getAllRequiredFuel(masses) == 4983626
    }

}
