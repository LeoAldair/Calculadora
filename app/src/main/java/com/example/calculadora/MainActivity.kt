package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculadora.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

}