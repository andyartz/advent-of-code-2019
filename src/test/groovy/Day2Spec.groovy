import spock.lang.Specification
import spock.lang.Unroll

class Day2Spec extends Specification {

    Day2 systemUnderTest = new Day2()

    @Unroll
    void "should solve for input #input"() {
        expect:
        systemUnderTest.run(input) == output

        where:
        input                                      | output
        [1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50] | [3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50]
        [1, 0, 0, 0, 99]                           | [2, 0, 0, 0, 99]
        [2, 3, 0, 3, 99]                           | [2, 3, 0, 6, 99]
        [2, 4, 4, 5, 99, 0]                        | [2, 4, 4, 5, 99, 9801]
        [1, 1, 1, 4, 99, 5, 6, 0, 99]              | [30, 1, 1, 4, 2, 5, 6, 0, 99]
    }

    void "should restore program"() {
        expect:
        systemUnderTest.restore([0, 0, 0, 0], 12, 2) == [0, 12, 2, 0]
    }

    void "should solve puzzle part 1"() {
        given:
        List<Integer> program = getClass().getResource('day2.txt').text.split(',')*.toInteger()

        expect:
        systemUnderTest.restore(program, 12, 2).with { systemUnderTest.run(it)[0] } == 12490719
    }

    void "should solve puzzle part 2"() {
        given:
        List<Integer> program = getClass().getResource('day2.txt').text.split(',')*.toInteger()
        int maxIndex = program.size()-1

        expect:
        [(0..maxIndex),(0..maxIndex)].combinations().find { int noun, int verb ->
            systemUnderTest.restore(program, noun, verb).with { systemUnderTest.run(it)[0] } == 19690720
        }.with { combination ->
            100 * combination[0] + combination[1]
        } == 2003
    }
}
