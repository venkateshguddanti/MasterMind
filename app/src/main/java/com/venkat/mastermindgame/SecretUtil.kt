package com.venkat.mastermindgame

import com.venkat.mastermindgame.Color.*
import java.util.*

private val letters = 'A'..'Z'
private val wordLength = 4

sealed class Color
{
    object RED : Color()
    object ORANGE : Color()
    object GREEN : Color()
}

fun evaluateSecret(secret: String, input: String) : MutableMap<Int,Color>{
    val map = mutableMapOf<Int,Color>(0 to RED,
        1 to RED,
        2 to RED,
        3 to RED)
      var newSecret =""
      var index : MutableMap<Int,Char> = mutableMapOf()
      for (i in input.indices)
      {
          if(secret[i] != input[i])
          {
              newSecret +=input[i]
              index[i] = input[i]
          }else
          {
              map[i] = GREEN
          }
      }
      if(newSecret.isNotEmpty())
      {
          for(i in newSecret.indices)
          {
              for(j in secret.indices) {
                  if (newSecret[i] == secret[j]) {
                      val filter = index.filter { (key,value)-> value == newSecret[i] }
                      filter.entries.forEach { (key,value)-> map[key] = ORANGE }
                  }
              }
          }
      }
    return map
}
fun generateWord(): String {
    val chars = letters.toMutableList()
    val random = Random()
    return buildString {
        for(i in 1..wordLength)
        {
            val letter = chars[random.nextInt(chars.size)]
            append(letter)
        }
    }.toLowerCase()
}

