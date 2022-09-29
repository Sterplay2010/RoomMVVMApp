package com.examen.radame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.examen.radame.databinding.ActivityRegisterBinding
import com.examen.radame.viewmodel.RegisterViewModel
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel:RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding.register.setOnClickListener {
            lifecycleScope.launch {
                viewModel.registerData(binding.model.text.toString(),
                    binding.submodel.text.toString(),
                    binding.year.text.toString())
            }
            binding.model.text.clear()
            binding.submodel.text.clear()
            binding.year.text.clear()
        }
        initObservers()
    }

    fun initObservers(){
        viewModel.result.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.error.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }
    }
}