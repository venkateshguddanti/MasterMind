package com.venkat.mastermindgame

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MasterMindsTest {

    private val expectedAllGreen = mapOf<Int,Color>(0 to Color.GREEN,
        1 to Color.GREEN,
        2 to Color.GREEN,
        3 to Color.GREEN)
    private val expectedAllRed = mapOf<Int,Color>(0 to Color.RED,
        1 to Color.RED,
        2 to Color.RED,
        3 to Color.RED)
    private val expectedAllOrange = mapOf<Int,Color>(0 to Color.ORANGE,
        1 to Color.ORANGE,
        2 to Color.ORANGE,
        3 to Color.ORANGE)
    private val expectedRandom = mapOf<Int,Color>(0 to Color.RED,
        1 to Color.GREEN,
        2 to Color.ORANGE,
        3 to Color.RED)

    private fun testEvaluation(secret : String, input : String,expected :Map<Int,Color>)
    {
        val result = evaluateSecret(secret,input)
        assertEquals(expected,result)
    }
    @Test
    fun testAllGreen() = testEvaluation("ABCD","ABCD",expectedAllGreen)
    @Test
    fun testAllRed() = testEvaluation("ABCD","EFGH",expectedAllRed)
    @Test
    fun testAllOrange() = testEvaluation("ABCD","DCBA",expectedAllOrange)
    @Test
    fun testRandom() = testEvaluation("ABCD","EBAF",expectedRandom)


}
