package fr.o80.aoc.day21

class AllergenInfo(
    val ingredients: List<String>,
    val allergens: List<String>
)

typealias Allergen = String
typealias Ingredient = String

class Day21 {

    fun part1(allergensInfo: List<AllergenInfo>): Int {
        val map = mutableMapOf<Allergen, Collection<Ingredient>>()
        fillPossibilities(map, allergensInfo)

        val potentialAllergen = map.flatMap { it.value }
        val allIngredients = allergensInfo.flatMap { it.ingredients }

        return (allIngredients - potentialAllergen).size
    }

    private fun fillPossibilities(
        allergens: MutableMap<Allergen, Collection<Ingredient>>,
        allergensInfo: List<AllergenInfo>
    ) {
        allergensInfo.forEach { info ->
            info.allergens.forEach { allergenName ->
                allergens[allergenName] = allergens[allergenName]?.intersect(info.ingredients) ?: info.ingredients
            }
        }
    }

    fun part2(allergensInfo: List<AllergenInfo>): String {
        val allergens = mutableMapOf<Allergen, Collection<Ingredient>>()
        fillPossibilities(allergens, allergensInfo)
        resolvePossibilities(allergens)

        return allergens.entries.sortedBy { it.key }.joinToString(",") { it.value.first() }
    }

    private fun resolvePossibilities(allergens: MutableMap<Allergen, Collection<Ingredient>>) {
        val resolvedAllergens = mutableListOf<Allergen>()

        while (allergens.size != resolvedAllergens.size) {

            allergens.forEach { (allergen, ingredients) ->
                if (allergen in resolvedAllergens) {
                    return@forEach
                }
                if (ingredients.size == 1) {
                    resolvedAllergens.add(allergen)
                    allergens.clean(allergen)
                    return@forEach
                }
            }

        }
    }

    private fun MutableMap<Allergen, Collection<Ingredient>>.clean(allergen: Allergen) {
        val foundIngredient = this[allergen]!!.first()
        this.filterValues { ingredients -> ingredients.size >= 2 && ingredients.contains(foundIngredient) }
            .forEach { (a, ingredients) -> this[a] = ingredients - foundIngredient }
    }

}
