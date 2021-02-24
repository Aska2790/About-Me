package com.aska.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.doneButton).setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        val nicknameEditText = findViewById<EditText>(R.id.nicknameEditText)
        val nicknameTextView = findViewById<TextView>(R.id.nicknameTextView)

        nicknameTextView.text = nicknameEditText.text.toString()
        nicknameTextView.isVisible = true
        nicknameEditText.isVisible = false
        view.isVisible = false

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}