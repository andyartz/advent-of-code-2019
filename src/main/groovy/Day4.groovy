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

    Integer getNumberOfPasswordsStrict(IntRange integers) {
        integers.count {
            [null, "$it".collect { it as Integer }, null].flatten().collate(4, 1, false).with { adjacentDigits ->
                adjacentDigits.find {
                    it[1] == it[2] && it[0] != it[1] && it[2] != it[3] // check inside pair first for efficiency
                } && adjacentDigits.every {
                    it[1] <= it[2]
                }
            }
        }
    }
}
