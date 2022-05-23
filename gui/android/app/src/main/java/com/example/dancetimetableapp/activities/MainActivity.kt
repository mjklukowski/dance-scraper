package com.example.dancetimetableapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.dancetimetableapp.R
import com.example.dancetimetableapp.databinding.ActivityMainBinding
import com.example.dancetimetableapp.dialogs.FilterDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val filterDialog = FilterDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_refresh) {
            val intent = Intent(this, LessonDetailsActivity::class.java)
            startActivity(intent)
            return true
        }

        if(item.itemId == R.id.action_filter) {
            filterDialog.show(supportFragmentManager, "filterDialog")
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}