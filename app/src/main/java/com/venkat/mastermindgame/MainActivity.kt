package com.venkat.mastermindgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val letters = 'A'..'Z'
    val word_length = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secret.text = generateWord().toLowerCase()
        one.apply { afterTextChanged(two) }
        two.apply { afterTextChanged(three) }
        three.apply { afterTextChanged(four) }

        check.setOnCheckedChangeListener { view, isCheckable->
            if(isCheckable) {
                val input = "${one.text}${two.text}${three.text}${four.text}"
                if(input.length<word_length){
                    Toast.makeText(this,"Please Enter 4 characters",Toast.LENGTH_LONG).show()
                    view.isChecked = false
                    return@setOnCheckedChangeListener
                }
                val result = evaluateSecret(
                    secret.text.toString(),input
                )
                result.forEach { (key, value) ->
                    when (key) {
                        0 -> updateBackground(one, value)
                        1 -> updateBackground(two, value)
                        2 -> updateBackground(three, value)
                        3 -> updateBackground(four, value)
                    }
                }
            }else
            {
                one.setBackgroundColor(ContextCompat.getColor(this,android.R.color.darker_gray))
                two.setBackgroundColor(ContextCompat.getColor(this,android.R.color.darker_gray))
                three.setBackgroundColor(ContextCompat.getColor(this,android.R.color.darker_gray))
                four.setBackgroundColor(ContextCompat.getColor(this,android.R.color.darker_gray))
            }
        }

    }
    private fun updateBackground(editText: EditText, color: Color)
    {
        when(color) {
            Color.RED -> editText.setBackgroundColor(ContextCompat.getColor(this,android.R.color.holo_red_dark))
            Color.ORANGE ->  editText.setBackgroundColor(ContextCompat.getColor(this,android.R.color.holo_orange_dark))
            Color.GREEN ->  editText.setBackgroundColor(ContextCompat.getColor(this,android.R.color.holo_green_dark))
        }

    }
 private fun generateWord(): String {
     val chars = letters.toMutableList()
     val random = Random()
     return buildString {
         for(i in 1..word_length)
         {
             val letter = chars[random.nextInt(chars.size)]
             append(letter)
         }
     }
 }
    private fun EditText.afterTextChanged(ui: EditText)
    {
        this.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(item: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(editText: CharSequence?, p1: Int, p2: Int, p3: Int) {
                editText?.let { if(it.length==1) ui.requestFocus() }
            }

        })
    }
}
