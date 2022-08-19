package com.marcoapm.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    //Common Android Pattern to use non-nullable variables:
    //lateinit -> informs that variable will be initialized before calling any operations on it. (basically, we promise that we will not leave it as null.
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById<Button>(R.id.roll_button)
        diceImage = findViewById<ImageView>(R.id.dice_image)

        rollButton.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1

        Toast.makeText(this, "$randomInt", Toast.LENGTH_SHORT).show()

        //sets the diceImage accordingly to randomInt value
        val drawableResource = when (randomInt){
            1 ->  R.drawable.dice_1
            2 ->  R.drawable.dice_2
            3 ->  R.drawable.dice_3
            4 ->  R.drawable.dice_4
            5 ->  R.drawable.dice_5
            else ->  R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }


}