import groovy.transform.ToString

@ToString(includePackage = false)
class Day1 {

    Integer getRequiredFuel(Integer mass) {
        (mass / 3) - 2
    }

    Integer getRequiredFuel(Collection<Integer> masses) {
        masses.sum { getRequiredFuel(it) } as Integer
    }

    Integer getAllRequiredFuel(Integer mass) {
        mass < 6 ? 0 : getRequiredFuel(mass).with { it + getAllRequiredFuel(it) }
    }

    Integer getAllRequiredFuel(Collection<Integer> masses) {
        masses.sum { getAllRequiredFuel(it) } as Integer
    }
}
