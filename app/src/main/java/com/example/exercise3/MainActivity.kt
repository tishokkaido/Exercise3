package com.example.exercise3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), Fragment1.OnToastClickListener, Fragment2.OnSubActivityClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onToastClicked() {
        Toast.makeText(this, "Fragment1 Button was Clicked!", Toast.LENGTH_SHORT).show()
    }

    override fun onSubActivityClicked() {
        // Intentの設定
        val intent = Intent(this, SubActivity::class.java).also {
            it.putExtra(INTENT_KEY, "MainActivityから移動")
        }
        startActivity(intent)
    }

    companion object {
        const val INTENT_KEY = "intent_key"
    }
}