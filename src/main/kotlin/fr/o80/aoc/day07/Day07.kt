package fr.o80.aoc.day07

class Day07 {

    fun containsShinyGold(rules: Map<BagColor, List<BagColor>>): Sequence<BagColor> {
        val memo = mutableMapOf<BagColor, Boolean>()
        return rules
            .asSequence()
            .filterNot { rule -> rule.key.isShinyGold }
            .filter { (bagColor, _) -> containsShinyGoldBag(bagColor, rules, memo) }
            .map { (bagColor, _) -> bagColor }
    }

    fun countBagsInShinyGoldBag(rules: Map<BagColor, List<BagColor>>): Int {
        val memo = mutableMapOf<BagColor, Int>()
        return countInnerBags(BagColor(1, "shiny gold"), rules, memo) - 1
    }

    private fun containsShinyGoldBag(
        bagColor: BagColor,
        rules: Map<BagColor, List<BagColor>>,
        memo: MutableMap<BagColor, Boolean>
    ): Boolean {
        if (bagColor in memo) {
            return memo[bagColor]!!
        }
        if (bagColor.isShinyGold)
            return true

        val innerColors = rules[bagColor]!!
        return innerColors.any { innerColor -> containsShinyGoldBag(innerColor, rules, memo) }
            .also { memo[bagColor] = it }
    }

    private fun countInnerBags(
        bagColor: BagColor,
        rules: Map<BagColor, List<BagColor>>,
        memo: MutableMap<BagColor, Int>
    ): Int {
        if (bagColor in memo) {
            return memo[bagColor]!!
        }
        val innerColors = rules[bagColor]!!

        val count = 1 + innerColors
            .map { innerBag -> innerBag.count * countInnerBags(innerBag, rules, memo) }
            .sum()
        memo[bagColor] = count
        return count
    }

}
