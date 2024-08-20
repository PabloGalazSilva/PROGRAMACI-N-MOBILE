package com.example.evaluacion1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContractEmployeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contract_employee)

        val salaryInput = findViewById<EditText>(R.id.salaryInput)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val netPaymentText = findViewById<TextView>(R.id.netPaymentText)
        val backButton = findViewById<Button>(R.id.backButton)

        calculateButton.setOnClickListener {
            val salary = salaryInput.text.toString().toDoubleOrNull() ?: 0.0
            val netPayment = ContractEmployee("Empleado", salary).calculateNetPayment()
            netPaymentText.text = "Pago Neto: $netPayment"
        }

        backButton.setOnClickListener {
            finish() // Vuelve a la pantalla principal
        }
    }
}
