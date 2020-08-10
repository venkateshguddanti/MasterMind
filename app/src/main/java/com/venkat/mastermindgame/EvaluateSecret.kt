package com.venkat.mastermindgame

import com.venkat.mastermindgame.Color.*

sealed class Color
{
    object RED : Color()
    object ORANGE : Color()
    object GREEN : Color()
}
var map : MutableMap<Int,Color> = mutableMapOf()

fun evaluateSecret(secret : String, input : String) : MutableMap<Int, Color>
{
     guessGreen(secret,input.toLowerCase())
     guessOrange(secret,input.toLowerCase())
     return map
}


fun guessOrange(secret: String, input: String){
      var newSecret =""
      var index : MutableMap<Int,Char> = mutableMapOf()
    for (i in input.indices)
      {
          if(secret[i] != input[i])
          {
              newSecret +=input[i]
              index[i] = input[i]
          }
      }
      if(newSecret.isNotEmpty())
      {
          for(i in newSecret.indices)
          {
              for(j in secret.indices) {
                  if (newSecret[i] == secret[j]) {
                      val position = getKey(index,newSecret[i])
                      position?.let { map[position] = ORANGE }
                  }
              }
          }
      }
}

fun guessGreen(secret: String, input: String) {
        for (i in secret.indices) {
            if (secret[i] == input[i]) {
                map[i] = GREEN
            }else{
                map[i] = RED
            }
        }
}
fun  getKey(map: Map<Int, Char>, target: Char): Int? {
    for ((key, value) in map) {
        if (target == value) {
            return key
        }
    }
    return null
}

