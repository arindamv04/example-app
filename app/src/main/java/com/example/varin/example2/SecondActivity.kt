package com.example.varin.example2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*
import java.util.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        shoRandomNumber()
    }

    companion object {
        const val TOTAL_COUNT = "Total_count"
    }
    fun shoRandomNumber(){

        //get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT,0)

//        generate a random number

        var randomInt = 0

        if (count>0){
            randomInt = Random().nextInt(count + 1)
        }

        //the random number replacing the value of the text in the second screen
        textView_random.text = randomInt.toString()

        //changing the %1d placeholder value to the count value
        textView_label.text = getString(R.string.random_heading,count)


    }

    fun homeMe(view: View){
        val homeIntent = Intent(this,MainActivity::class.java)

        startActivity(homeIntent)
    }
}
