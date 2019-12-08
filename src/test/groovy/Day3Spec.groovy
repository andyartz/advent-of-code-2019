import math.geom2d.line.Line2D
import spock.lang.Specification
import spock.lang.Unroll

class Day3Spec extends Specification {

    Day3 systemUnderTest = new Day3()

    void "library should determine intersections and colinearity"() {
        given:
        Line2D a = new Line2D(0, 0, 4, 4)
        Line2D b = new Line2D(3, 3, 8, 8)

        expect:
        a.isColinear(b)
        !a.intersections(b)
    }

    @Unroll
    void "should solve for wire path #wirePath"() {
        expect:
        systemUnderTest.getDistanceToClosestIntersection(wirePath) == expectedDistance

        where:
        wirePath                                                                                | expectedDistance
        ['R8,U5,L5,D3', 'U7,R6,D4,L4']                                                          | 6
        ['R75,D30,R83,U83,L12,D49,R71,U7,L72', 'U62,R66,U55,R34,D71,R55,D58,R83']               | 159
        ['R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51', 'U98,R91,D20,R16,D67,R40,U7,R15,U6,R7'] | 135
    }

    void "should solve puzzle part 1"() {
        given:
        List<String> wirePaths = getClass().getResource('day3.txt').readLines()

        expect:
        systemUnderTest.getDistanceToClosestIntersection(wirePaths) == 860
    }

    @Unroll
    void "should solve for number of steps to an intersection for wire path #wirePath"() {
        expect:
        systemUnderTest.getShortestPathToIntersection(wirePath) == expectedSteps
        where:
        wirePath                                                                                | expectedSteps
        ['R8,U5,L5,D3', 'U7,R6,D4,L4']                                                          | 30
        ['R75,D30,R83,U83,L12,D49,R71,U7,L72', 'U62,R66,U55,R34,D71,R55,D58,R83']               | 610
        ['R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51', 'U98,R91,D20,R16,D67,R40,U7,R15,U6,R7'] | 410
    }

    void "should solve puzzle part 2"() {
        given:
        List<String> wirePaths = getClass().getResource('day3.txt').readLines()

        expect:
        systemUnderTest.getShortestPathToIntersection(wirePaths) == 9238
    }
}
