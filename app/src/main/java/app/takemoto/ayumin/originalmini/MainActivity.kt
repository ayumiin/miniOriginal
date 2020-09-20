package app.takemoto.ayumin.originalmini

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var firstNumber = 0
    var secondNumber =0
    var totalNumber = 0
    var operator = "empty"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.isEnabled = false
        minusButton.isEnabled = false
        multiplyButton.isEnabled = false
        equalButton.isEnabled = false

        numberTextView.text = firstNumber.toString()

        numberButton0.setOnClickListener {

            if(operator == "empty"){
                firstNumber = firstNumber * 10 + 0
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 + 0
                numberTextView.text = secondNumber.toString()
            }
        }


        numberButton1.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+1
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +1
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton2.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+2
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +2
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton3.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+3
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +3
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton4.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+4
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +4
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton5.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+5
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +5
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton6.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+6
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +6
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton7.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+7
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +7
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton8.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+8
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +8
                numberTextView.text = secondNumber.toString()
            }
        }

        numberButton9.setOnClickListener {

            if(operator == "empty"){

                firstNumber = firstNumber*10+9
                numberTextView.text = firstNumber.toString()

                plusButton.isEnabled = true
                minusButton.isEnabled = true
                multiplyButton.isEnabled = true
                equalButton.isEnabled = true
            }else{
                secondNumber = secondNumber * 10 +9
                numberTextView.text = secondNumber.toString()
            }
        }

        plusButton.setOnClickListener {
            operator = "plus"
            numberTextView.text = secondNumber.toString()
        }

        minusButton.setOnClickListener {
            operator = "minus"
            numberTextView.text = secondNumber.toString()
        }

        multiplyButton.setOnClickListener {
            operator = "multiply"
            numberTextView.text = secondNumber.toString()
        }

        equalButton.setOnClickListener {
            if(operator == "plus"){
                totalNumber = firstNumber + secondNumber
            }else if(operator == "minus"){
                totalNumber = firstNumber - secondNumber
            }else if(operator == "multiply"){
                totalNumber = firstNumber * secondNumber
            }

            firstNumber = 0
            secondNumber = 0
            operator = "empty"
            numberTextView.text = totalNumber.toString()
        }

        clearButton.setOnClickListener {

            firstNumber = 0
            secondNumber = 0
            totalNumber = 0

            operator ="empty"
            numberTextView.text = totalNumber.toString()
        }

        backButton.setOnClickListener {
            val toSecondActivity = Intent(this,SecondActivity::class.java)
            startActivity(toSecondActivity)
            finish()
        }

        saveButton.setOnClickListener {
            val saveNumber = numberTextView.text.toString()
            val saveTitle = titleView.text.toString()

            if (saveNumber.isNotEmpty()){

                val savePage = Intent(this,SecondActivity::class.java)

                savePage.putExtra("money",saveNumber)
                savePage.putExtra("title",saveTitle)

                startActivity(savePage)
                finish()
            }
        }

    }

   /* override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
    */
}