package com.example.walmartcodingofnitya.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartcodingofnitya.R
import com.example.walmartcodingofnitya.data.repository.CountryRepository
import com.example.walmartcodingofnitya.databinding.ActivityMainBinding
import com.example.walmartcodingofnitya.domain.usecase.CountryUseCase
import com.example.walmartcodingofnitya.presentation.view.adapter.CountryListAdapter
import com.example.walmartcodingofnitya.presentation.viewmodel.CountryViewModel
import com.example.walmartcodingofnitya.presentation.viewmodel.CountryViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryViewModel: CountryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initializeViews()
        setUpObservers()


    }
    private fun initializeViews() {
        val repository = CountryRepository()
        val useCase = CountryUseCase(repository)
        val factory = CountryViewModelFactory(useCase)
        countryViewModel = ViewModelProvider(this,factory )[CountryViewModel::class.java]

    }

    private fun setUpObservers() {

        countryViewModel.countryDataList.observe(this){countryList->
            val adapter = CountryListAdapter(countryList)
            Log.d("countryList" , countryList.toString())

            binding.countryRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.countryRecyclerView.adapter = adapter
        }

        countryViewModel.error.observe(this){
            AlertDialog.Builder(this@MainActivity)
                .setTitle(ERROR_MSG)
                .setMessage(it)
                .create()
                .show()
        }
    }
    companion object{
        const val ERROR_MSG = "error"
    }
}