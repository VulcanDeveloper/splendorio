package domain
import java.lang.IllegalArgumentException

class Noble(val score: Int, val prices: Map<Card, Int>){
    companion object{
        @JvmStatic
        fun fromLine(line: String): Noble {
            val column = line.split("|")
            val listPrice = column[1].substring(1, column[1].length - 1).split(",")
            val price = mutableMapOf({
                Gem.WHITE to listPrice[0].toInt(),
                Gem.BLUE to listPrice[1].toInt(),
                Gem.GREEN to listPrice[2].toInt(),
                Gem.RED to listPrice[3].toInt(),
                Gem.BLACK to listPrice[4].toInt()
            }).filterValues { it != 0 }
            return Noble(column[0].toInt(),price)
        }
    }
}
