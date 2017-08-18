package com.example.varin.example2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun toastMe(view:View){
        val myToast = Toast.makeText(this, "Hello toast!", Toast.LENGTH_SHORT)
        myToast.show()
    }
    fun countMe(view: View){
        //getting the field by field id
       // val showCountTextView = findViewById<TextView>(R.id.textView) this is a laborous process. with an extension,
        //we can directly access the texxt view

        //getting the text attribute from the textview object
        val countString = textView.text.toString() //access the text view directly using the text view id

        //convert the text to int and store it into a different variable
        var count: Int = countString.toInt()
        count++ //increment the variable

        //turn the incremented variable into string again and feed it back to the view object/text
        textView.text = count.toString()


    }

    fun resetMe(view: View){
        textView.text = "0"
    }

    fun randomMe(view: View){
        //create an intent to start the second activity.
        val randomIntent = Intent(this,SecondActivity::class.java)

        //get the current value of the text view
        val countString = textView.text.toString()

        //convert the val to int
        val count = Integer.parseInt(countString) //i think this can also be written as countString.toInt()

        //put the extra information through the random intent
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT,count)//why are we sending an int to totalcount which is a string

        //start the new activity
        startActivity(randomIntent)
    }


}
