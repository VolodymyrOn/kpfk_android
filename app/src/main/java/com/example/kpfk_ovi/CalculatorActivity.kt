package com.example.kpfk_ovi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val button1=findViewById<Button>(R.id.button1)
        val button2=findViewById<Button>(R.id.button2)
        val button3=findViewById<Button>(R.id.button3)
        val button4=findViewById<Button>(R.id.button4)
        val button5=findViewById<Button>(R.id.button5)
        val button6=findViewById<Button>(R.id.button6)
        val button7=findViewById<Button>(R.id.button7)
        val button8=findViewById<Button>(R.id.button8)
        val button9=findViewById<Button>(R.id.button9)
        val button0=findViewById<Button>(R.id.button0)

        val buttonplus=findViewById<Button>(R.id.buttonPlus)
        val buttonminus=findViewById<Button>(R.id.buttonMin)
        val buttonmnog=findViewById<Button>(R.id.buttonmul)
        val buttondil=findViewById<Button>(R.id.buttonDil)
        val buttondoriv=findViewById<Button>(R.id.buttonEq)
        val buttonclear=findViewById<Button>(R.id.buttonCL)

        val et=findViewById<TextView>(R.id.textView3)
        val dor=findViewById<TextView>(R.id.textView2)

        val buttons= listOf<Button>(button1,button2,button3,button4,button5,button6,button7,button8,button9,button0)
        val buttons2= listOf<Button>(buttondil,buttonmnog,buttonminus,buttonplus)

        var first_number=0;
        var second_number="";
        var znak=""




        buttons.forEach { button ->
            button.setOnClickListener {
                val value = et.text.toString() + (it as Button).text.toString()
                et.setText(value)

                if (znak != "") {
                    second_number = et.text.toString()
                    var dor1 = 0
                    if (second_number != "") {
                        if (znak == getString(R.string.plus)) {
                            dor1 = first_number.toInt() + second_number.toInt()
                        } else if (znak == getString(R.string.minus)) {
                            dor1 = first_number.toInt() - second_number.toInt()
                        } else if (znak == getString(R.string.multiply)) {
                            dor1 = first_number.toInt() * second_number.toInt()
                        } else if (znak == getString(R.string.slash)) {
                            if (second_number != getString(R.string.__0)) {
                                dor1 = first_number.toInt() / second_number.toInt()
                            } else {
                                Toast.makeText(this,
                                    getString(R.string.divide_0_error), Toast.LENGTH_SHORT)
                                    .show()
                                et.text = ""
                                second_number = ""
                            }
                        }
                        dor.text = dor1.toString()
                        second_number = ""
                    }
                }
            }
            buttons2.forEach { button ->
                button.setOnClickListener {
                    first_number = et.text.toString().toInt()
                    if (first_number != null) {
                        znak = (it as Button).text.toString()
                        et.text = ""
                        dor.text = first_number.toString() + znak + "..."
                    }
                }
            }

            buttonclear.setOnClickListener {
                et.text = ""
            }


            buttondoriv.setOnClickListener {
                second_number = et.text.toString()
                var dor1 = 0
                if (second_number != "") {
                    if (znak == getString(R.string.plus)) {
                        dor1 = first_number.toInt() + second_number.toInt()
                    } else if (znak == getString(R.string.minus)) {
                        dor1 = first_number.toInt() - second_number.toInt()
                    } else if (znak == getString(R.string.multiply)) {
                        dor1 = first_number.toInt() * second_number.toInt()
                    } else if (znak == getString(R.string.slash)) {
                        if (second_number != getString(R.string.__0)) {
                            dor1 = first_number.toInt() / second_number.toInt()
                        } else {
                            Toast.makeText(this,
                                getString(R.string.divide_0_error), Toast.LENGTH_SHORT)
                                .show()
                            et.text = ""
                            second_number = ""
                        }
                    }
                    dor.text = dor1.toString()
                    znak = ""
                    first_number = 0;
                    second_number = ""
                }
            }
        }



    }
}