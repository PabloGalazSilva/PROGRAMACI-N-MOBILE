package com.example.evaluacion1

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun HonoraryEmployeeScreen(onBack: () -> Unit) {
    var salary by remember { mutableStateOf("") }
    var netPayment by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Cálculo de Pago de Honorarios")
        TextField(
            value = salary,
            onValueChange = { salary = it },
            label = { Text("Salario Bruto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            netPayment = HonoraryEmployee("Empleado", salary.toDoubleOrNull() ?: 0.0).calculateNetPayment()
        }) {
            Text("Calcular Pago Neto")
        }
        netPayment?.let {
            Text("Pago Neto: $it")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Volver")
        }
    }
}
