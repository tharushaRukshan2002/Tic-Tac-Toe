package com.example.tic_tac_toe

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val buttonList = mutableListOf<Button>()

    private lateinit var winnerTxt: TextView
    var clicks = 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonList.add(findViewById(R.id.button00))
        buttonList.add(findViewById(R.id.button01))
        buttonList.add(findViewById(R.id.button02))
        buttonList.add(findViewById(R.id.button10))
        buttonList.add(findViewById(R.id.button11))
        buttonList.add(findViewById(R.id.button12))
        buttonList.add(findViewById(R.id.button20))
        buttonList.add(findViewById(R.id.button21))
        buttonList.add(findViewById(R.id.button22))

        val h1 = mutableListOf(buttonList[0], buttonList[1], buttonList[2])
        val h2 = mutableListOf(buttonList[3], buttonList[4], buttonList[5])
        val h3 = mutableListOf(buttonList[6], buttonList[7], buttonList[8])

        val v1 = mutableListOf(buttonList[0], buttonList[3], buttonList[6])
        val v2 = mutableListOf(buttonList[1], buttonList[4], buttonList[7])
        val v3 = mutableListOf(buttonList[2], buttonList[5], buttonList[8])

        val d1 = mutableListOf(buttonList[0], buttonList[4], buttonList[8])
        val d2 = mutableListOf(buttonList[2], buttonList[4], buttonList[6])


        val correct: Array<MutableList<Button>> = arrayOf(h1, h2, h3, v1, v2, v3, d1, d2)





        winnerTxt = findViewById(R.id.winnerTxt)

        buttonList[0].setOnClickListener {
            playerAction(buttonList[0], correct)

        }

        buttonList[1].setOnClickListener {
            playerAction(buttonList[1], correct)

        }

        buttonList[2].setOnClickListener {
            playerAction(buttonList[2], correct)

        }

        buttonList[3].setOnClickListener {
            playerAction(buttonList[3], correct)

        }

        buttonList[4].setOnClickListener {
            playerAction(buttonList[4], correct)

        }

        buttonList[5].setOnClickListener {
            playerAction(buttonList[5], correct)

        }

        buttonList[6].setOnClickListener {
            playerAction(buttonList[6], correct)

        }

        buttonList[7].setOnClickListener {
            playerAction(buttonList[7], correct)

        }

        buttonList[8].setOnClickListener {
            playerAction(buttonList[8], correct)

        }

    }

    /**
     * action of the player
     */
    @SuppressLint("SetTextI18n")
    private fun playerAction(button: Button, correct: Array<MutableList<Button>> ) {
        button.text = "X"
        button.setTextColor(Color.GREEN)
        button.isClickable = false
        clicks++
        val wonOrNot = checkWin("X",correct)
        if (wonOrNot ){
            winnerTxt.text = "You won."
            winnerTxt.setTextColor(Color.GREEN)
            btnDisableFun()
            Log.i("num", "$clicks")
            return
        }

        if (clicks == 9){
            Log.i("num", "Final: $clicks")
            return
        }

        computerAction(correct)

    }

    private fun computerAction( correct: Array<MutableList<Button>> ) {
        var randomNum = (0 until buttonList.size).random()
        while ( !buttonList[randomNum].isClickable){
            randomNum = (0 until buttonList.size).random()
        }
        buttonList[randomNum].text = "O"
        buttonList[randomNum].setTextColor(Color.RED)
        buttonList[randomNum].isClickable = false
        clicks++

    }

    @SuppressLint("SetTextI18n")
    private fun checkWin(s: String, correct: Array<MutableList<Button>>): Boolean{
        var i = 0
        while (i < correct.size){
            if ( correct[i][0].text == s  &&  correct[i][1].text == s &&  correct[i][2].text == s ){
                return true;
            }
            i++
        }
        return false;
    }

    private fun btnDisableFun(){
        var i = 0
        while ( i < buttonList.size){
            buttonList[i].isClickable = false
            i++
        }
    }
}