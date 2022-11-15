package com.kamrulhasan.primenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val TAG = "main activity"

    private lateinit var btnSubmit: Button
    private lateinit var etInput: EditText
    private lateinit var tvResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit = this.findViewById(R.id.btn_find)
        etInput = this.findViewById(R.id.et_take_prime)
        tvResult = this.findViewById(R.id.tv_result)

        var numInt = 0


        Log.d(TAG, "onCreate: numINtI: $numInt")

////
////        val  inputString = etInput.toString()
//        val numberString = etInput.text.toString()
//        val number: Int = nu

        btnSubmit.setOnClickListener(View.OnClickListener {
            val numString = etInput.text.toString()
            if(numString != ""){
                numInt = numString.toInt()
            }
            val primeObj = PrimeNumber(numInt)
            var result = primeObj.findPrimeNumber()
            tvResult.text = "${numInt} th Prime Number is ${result}"//"${inputString} 'th Prime Number is ${result}"

        })
    }
}


class PrimeNumber(val nThPrimeNumber: Int){
    var primeIndex : Int = 0

    fun findPrimeNumber(): Int{
        var num = 3
        var rtValue = 0
        var flag = false
        var result: Int = 0

        //println(nThPrimeNumber)
        while (primeIndex < nThPrimeNumber){
            rtValue = Math.sqrt(num.toDouble()).toInt()
            flag = true
            for (i in 2..rtValue){
                //print(i)
                if(num % i == 0){
                    flag = false
                    break
                }
            }
            if(flag == true){
                primeIndex += 1
                result = num
            }

            num += 1
        }
        return result
    }
}