package com.example.lab0311bt01new


import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail: EditText
    private lateinit var inputNumber: EditText
    private lateinit var showButton: Button
    private lateinit var outputText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEmail = findViewById(R.id.inputEmail)
        inputNumber = findViewById(R.id.inputNumber)
        showButton = findViewById(R.id.showButton)
        outputText = findViewById(R.id.outputText)

        showButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val phone = inputNumber.text.toString()

            if (isEmailValid(email) && isPhoneValid(phone)) {
                outputText.text = "Email và số điện thoại hợp lệ!"
            } else {
                outputText.text = getErrorMessage(email, phone)
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPhoneValid(phone: String): Boolean {
        return phone.matches("\\d+".toRegex())
    }

    private fun getErrorMessage(email: String, phone: String): String {
        return when {
            !isEmailValid(email) && !isPhoneValid(phone) -> "Email và số điện thoại không hợp lệ!"
            !isEmailValid(email) -> "Email không hợp lệ!"
            else -> "Số điện thoại không hợp lệ!"
        }
    }
}
