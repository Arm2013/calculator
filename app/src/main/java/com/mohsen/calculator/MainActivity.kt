package com.mohsen.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{setTextFields("0")}
        btn_1.setOnClickListener{setTextFields("1")}
        btn_2.setOnClickListener{setTextFields("2")}
        btn_3.setOnClickListener{setTextFields("3")}
        btn_4.setOnClickListener{setTextFields("4")}
        btn_5.setOnClickListener{setTextFields("5")}
        btn_6.setOnClickListener{setTextFields("6")}
        btn_7.setOnClickListener{setTextFields("7")}
        btn_8.setOnClickListener{setTextFields("8")}
        btn_9.setOnClickListener{setTextFields("9")}
        btn_pl.setOnClickListener{setTextFields("(")}
        btn_pr.setOnClickListener{setTextFields(")")}
        btn_taghsim.setOnClickListener{setTextFields("/")}
        btn_zarb.setOnClickListener{setTextFields("*")}
        btn_jam.setOnClickListener{setTextFields("+")}
        btn_menha.setOnClickListener{setTextFields("-")}
        btn_momayez.setOnClickListener{setTextFields(".")}

        btn_ac.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }

        btn_back.setOnClickListener{
            val str = math_operation.text.toString()
            if(str.isNotEmpty()){
                math_operation.text = str.substring(0, str.length-1)
            }
            result_text.text = ""
        }

        btn_mosavi.setOnClickListener {
            try{
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()

                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()

            }catch(e:Exception){
                Log.d("Ошибка", "Сообщение: ${e.message}")
            }
        }

    }

    fun setTextFields(str: String){
        if(result_text.text !=""){
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }

}