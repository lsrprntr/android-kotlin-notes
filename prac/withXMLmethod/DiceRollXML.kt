package com.example.diceroller

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    //On create screen layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logging()
        division()

        //sets listener on button waiting for click which calls rollDice()
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }

        // Roll dice on create launch
        rollDice()
    }

    // function rolls dice
    private fun rollDice() {
        //create dice object with 6 sides stores roll in diceRoll
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //finds dice imageview
        val diceImage: ImageView = findViewById(R.id.imageView)

        //set drawable to diceRoll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")
    }
    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(4) {
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }

}


// object Dice takes int for sides
class Dice(private val numSides: Int) {

    //object has roll method
    fun roll(): Int {
        return (1..numSides).random()
    }
}