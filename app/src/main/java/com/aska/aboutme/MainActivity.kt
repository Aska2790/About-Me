package com.aska.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import com.aska.aboutme.databinding.ActivityMainDataBinding

class MainActivity : AppCompatActivity() {

    //region Properties

    private lateinit var dataBinding: ActivityMainDataBinding
    private val userNameModel = NameModel("Aleks Haecky")

    //endregion

    //region Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityMainDataBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        dataBinding.nameModel = userNameModel
        dataBinding.doneButton.setOnClickListener {
            addNickName()
        }
    }

    //endregion

    //region Actions

    private fun addNickName() {

        dataBinding.apply {
            val inputNickname = nicknameEditText.text.toString()

            if (inputNickname.isNotEmpty()) {
                nameModel = userNameModel.copy(nickname = inputNickname)
                nicknameTextView.isVisible = true
                nicknameEditText.isVisible = false
                doneButton.isVisible = false
            }

            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(root.windowToken, 0)
        }
    }

    //endregion
}