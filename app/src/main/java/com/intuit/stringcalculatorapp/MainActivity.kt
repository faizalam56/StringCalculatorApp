package com.intuit.stringcalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.intuit.stringcalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.btnAdd.setOnClickListener {
            //addValue()
            addNewValue()
        }
    }

    private fun addValue(){
        val stringCalculator = StringCalculator()

        val value = mBinding.etValue.text.toString()
        if (value.isNotEmpty()){
            if(stringCalculator.isValidInput(value)){
                mBinding.tvResult.text = stringCalculator.add(value).toString()

            }else{
                Toast.makeText(this,"Please enter valid data",Toast.LENGTH_LONG).show()
            }
        }else Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show()
    }

    private fun addNewValue(){
        val value = mBinding.etValue.text.toString()
        if (value.isNotEmpty()){
            mBinding.tvResult.text = CalculatorString.add(value).toString()

        }else Toast.makeText(this,"Please enter value",Toast.LENGTH_LONG).show()
    }
}