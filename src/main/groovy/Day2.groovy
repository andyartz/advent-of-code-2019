class Day2 {
    List<Integer> run(List<Integer> instructions) {
        for (int i = 0; i < instructions.size(); i += 4) {
            switch (instructions[i]) {
                case 1: instructions[instructions[i+3]] = instructions[instructions[i+1]] + instructions[instructions[i+2]]; break
                case 2: instructions[instructions[i+3]] = instructions[instructions[i+1]] * instructions[instructions[i+2]]; break
                case 99: return instructions
                default: throw new IllegalArgumentException("Invalid instruction opcode ${instructions[i]} at index $i")
            }
        }
        throw new IllegalArgumentException("Reached end of execution without encountering HALT opcode (99). Final output would have been $instructions")
    }

    List<Integer> restore(List<Integer> instructions) {
        instructions.tap {
            it[1] = 12
            it[2] = 2
        }
    }
}
