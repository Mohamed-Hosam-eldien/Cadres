package com.example.cadres.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cadres.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
//        val navController = findNavController(R.id.nav_host)
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }

}