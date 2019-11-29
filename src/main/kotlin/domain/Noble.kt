package domain
import java.lang.IllegalArgumentException

class Noble(val name: String, val score: Int, val prices: Map<Gem, Int>){
    companion object{
        @JvmStatic
        fun fromLine(line: String): Noble {
            try {
                val column = line.split("|")
                val listPrice = column[2].substring(1, column[2].length - 1).split(",")
                val price = mutableMapOf(
                        Gem.WHITE to listPrice[0].toInt(),
                        Gem.BLUE to listPrice[1].toInt(),
                        Gem.GREEN to listPrice[2].toInt(),
                        Gem.RED to listPrice[3].toInt(),
                        Gem.BLACK to listPrice[4].toInt()
                ).filterValues { it != 0 }
                return Noble(column[0], column[1].toInt(), price)
            }catch (e: Exception){
                throw IllegalArgumentException()
            }

        }
    }
}
