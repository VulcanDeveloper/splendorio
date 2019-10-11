import java.lang.IllegalArgumentException

class Card private constructor(
        val level: Int,
        val score: Int,
        val resource: Gem,
        val prices: Map<Gem, Int>
) {

    companion object {

        @JvmStatic
        fun fromLine(line: String): Card {
            val column = line.split("|")
            require(column.size == 4)
            val gem = when (column[2].toLowerCase()) {
                "white" -> Gem.WHITE
                "blue" -> Gem.BLUE
                "green" -> Gem.GREEN
                "red" -> Gem.RED
                "black" -> Gem.BLACK
                else -> throw IllegalArgumentException("type not match")
            }

            val listPrice = column[3].substring(1, column[3].length - 1).split(",")
            val price = mutableMapOf(
                    Gem.WHITE to listPrice[0].toInt(),
                    Gem.BLUE to listPrice[1].toInt(),
                    Gem.GREEN to listPrice[2].toInt(),
                    Gem.RED to listPrice[3].toInt(),
                    Gem.BLACK to listPrice[4].toInt()
            ).filterValues { it != 0 }
            return Card(column[0].toInt(), column[1].toInt(), gem, price)
        }
    }
}
