package com.hamalawey.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val viewModel : MealsViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

val mealzAdapter = MealsAdapter()
val rv = findViewById<RecyclerView>(R.id.category_rv)
         viewModel.getMeals()
        lifecycleScope.launch{
            viewModel.categories.collect{
                mealzAdapter.submitList(it?.categories)

                rv.adapter=mealzAdapter


            }
        }


    }
}