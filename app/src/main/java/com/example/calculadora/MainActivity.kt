package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: Char = '0'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        
        binding.buttonClear.setOnClickListener { 
            binding.editTextNumber.text.clear()
        }

        binding.buttonDelete.setOnClickListener {
            binding.editTextNumber.setText(binding.editTextNumber.text.dropLast(1))
        }
        binding.buttonResultado.setOnClickListener {
            when(operator){
                '*' -> {
                    binding.editTextNumber.setText("${firstValue * binding.editTextNumber.text.toString().toDouble()}")
                }
                '/' -> {
                    binding.editTextNumber.setText("${firstValue / binding.editTextNumber.text.toString().toDouble()}")
                }
                '+' -> {
                    binding.editTextNumber.setText("${firstValue + binding.editTextNumber.text.toString().toDouble()}")
                }
                '-' -> {
                    binding.editTextNumber.setText("${firstValue - binding.editTextNumber.text.toString().toDouble()}")
                }
                else -> {
                    binding.editTextNumber.setText("SYNTAX ERROR")
                }
            }
            operator = '0'
        }
        binding.buttonPorcentaje.setOnClickListener {
            binding.editTextNumber.setText(percentage(operator))
            operator = '0'
        }

    }

    fun percentage(OperatorToUse: Char): String {
        when(OperatorToUse){
            '+' -> {
                return "${firstValue + (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"
            }
            '-' -> {
                return "${firstValue - (firstValue*binding.editTextNumber.text.toString().toDouble()/100)}"
            }
            '0' -> {
                return "${binding.editTextNumber.text.toString().toDouble()/100}"
            }
            else -> {
                return "SYNTAX ERROR"
            }
        }
    }

    fun numberButtonClicked(view: View){
        val button = view as Button

        if(button.id.equals(binding.buttonPunto.id)){
            if(!binding.editTextNumber.text.contains('.')){
                binding.editTextNumber.text.append(button.text)
            }
        }else{
            binding.editTextNumber.text.append(button.text)
        }
    }

    fun operatorButtonClicked(view: View){
        val button = view as Button

        operator = when(button.id){
            binding.buttonMultiplicacion.id -> {'*'}
            binding.buttonDivision.id -> {'/'}
            binding.buttonSuma.id -> {'+'}
            binding.buttonResta.id -> {'-'}
            else -> {'0'}
        }

        firstValue = binding.editTextNumber.text.toString().toDouble()
        binding.editTextNumber.text.clear()
    }

}