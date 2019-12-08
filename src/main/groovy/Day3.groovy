import math.geom2d.Point2D
import math.geom2d.line.Line2D

class Day3 {

    Point2D origin = new Point2D(0,0)

    Integer getDistanceToClosestIntersection(List<String> wirePaths) {
        Set<Point2D> intersections = getWires(wirePaths).combinations().collectMany { a, b -> getIntersections(a, b) }
        intersections.removeIf { it == new Point2D(0,0) }
        intersections.collect { it.x().abs() + it.y().abs() }.min()
    }

    Integer getShortestPathToIntersection(List<String> wirePaths) {
        getWires(wirePaths).with { wires ->
            wires.collect { (0..it.size()-1) }.combinations().findResults { a, b ->
                List<Line2D> wireA = wires[0][0..a]
                List<Line2D> wireB = wires[1][0..b]

                (getIntersections(wireA.last(), wireB.last()) - origin) ? getStepsToIntersection(wireA, wireB) : null
            }
        }.min()
    }

    private List<List<Line2D>> getWires(List<String> wirePaths) {
        assert wirePaths.size() == 2

        List<List<Line2D>> wires = wirePaths*.split(',').collect { getWireSegments(it as List) }
        wires
    }

    private List<Line2D> getWireSegments(List<String> wirePathVectors) {
        List<Line2D> wirePathSegments = []

        wirePathVectors.inject(new Point2D(0, 0)) { previousPoint, pathSegment ->
            Point2D nextPoint
            Integer length = pathSegment[1..-1] as Integer
            String direction = pathSegment[0]

            switch (direction) {
                case 'U': nextPoint = previousPoint.translate(0, length); break
                case 'D': nextPoint = previousPoint.translate(0, -length); break
                case 'L': nextPoint = previousPoint.translate(-length, 0); break
                case 'R': nextPoint = previousPoint.translate(length, 0); break
                default: throw new IllegalArgumentException("Expected direction to be U, D, L, or R -- Found $direction")
            }

            nextPoint.tap {
                wirePathSegments << new Line2D(previousPoint, it)
            }
        }

        wirePathSegments
    }

    private List<Point2D> getIntersections(Line2D a, Line2D b) {
        a.intersections(b) ?: a.isColinear(b) ? getColinearIntersections(a, b) : []
    }

    List<Point2D> getColinearIntersections(Line2D a, Line2D b) {
        if ([a.x1, a.x2, b.x1, b.x2].unique().size() == 1) {
            (a.y1.toInteger()..a.y2.toInteger()).intersect((b.y1.toInteger()..b.y2.toInteger())).collect { new Point2D(a.x1, it) }
        } else {
            (a.x1.toInteger()..a.x2.toInteger()).intersect((b.x1.toInteger()..b.x2.toInteger())).collect { new Point2D(it, a.y1) }
        }
    }

    Integer getStepsToIntersection(List<Line2D> wireA, List<Line2D> wireB) {
        getStepsToIntersection(wireA.removeLast(), wireB.removeLast()) + ([wireA, wireB].collectMany { it*.length() }.sum() as Integer ?: 0)
    }

    Integer getStepsToIntersection(Line2D a, Line2D b) {
        getIntersections(a, b).collect {
            it.distance(a.firstPoint()) + it.distance(b.firstPoint())
        }.min()
    }
}