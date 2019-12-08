class Day4 {

    Integer getNumberOfPasswords(IntRange integers) {
        integers.count {
            "$it".collect { it as Integer }.collate(2, 1, false).with { adjacentDigits ->
                adjacentDigits.find {
                    it[0] == it[1]
                } && adjacentDigits.every {
                    it[0] <= it[1]
                }
            }
        }
    }
}
