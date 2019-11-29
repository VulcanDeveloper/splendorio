import org.junit.Assert
import org.junit.Test

class NobleGeneratorTest {

    private val validNobleList = arrayOf("A1","A2", "A3", "B1", "B2", "B3", "C1", "C2", "D1", "D2")

    private val nobleNames = arrayListOf<String>()

    @Test
    /* random(5) --> {Noble...Noble} */
    fun `When input 5 - Should return 5 different nobles`() {
        val nobles = NobleGenerator.random(5)
        nobles.forEach { nobleNames.add(it.name) }
        Assert.assertEquals(5, nobles.size)
        Assert.assertEquals(5, nobleNames.distinct().size)
        nobleNames.forEach { Assert.assertTrue(validNobleList.contains(it)) }
    }

    @Test
    fun `When input 4 - Should return 4 different nobles`() {
        val nobles = NobleGenerator.random(4)
        nobles.forEach { nobleNames.add(it.name) }
        Assert.assertEquals(4, nobles.size)
        Assert.assertEquals(4, nobleNames.distinct().size)
        nobleNames.forEach { Assert.assertTrue(validNobleList.contains(it)) }
    }

    @Test
    fun `When input 3 - Should return 3 different nobles`() {
        val nobles = NobleGenerator.random(3)
        nobles.forEach { nobleNames.add(it.name) }
        Assert.assertEquals(3, nobles.size)
        Assert.assertEquals(3, nobleNames.distinct().size)
        nobleNames.forEach { Assert.assertTrue(validNobleList.contains(it)) }
    }

}