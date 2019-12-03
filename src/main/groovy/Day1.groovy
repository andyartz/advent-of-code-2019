import groovy.transform.ToString

@ToString(includePackage = false)
class Day1 {

    Integer getRequiredFuel(Integer mass) {
        (mass / 3) - 2
    }

    Integer getRequiredFuel(Collection<Integer> masses) {
        masses.sum { getRequiredFuel(it) } as Integer
    }
}
