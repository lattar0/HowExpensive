package com.example.howexpensive.ui.screens.add

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.howexpensive.data.model.TransactionType
import com.example.howexpensive.R
import com.example.howexpensive.ui.theme.Padding

@Composable
fun AddTransactionScreen(
    onBack: () -> Unit,
    viewModel: AddTransactionViewModel = hiltViewModel()
) {
    var description by remember { mutableStateOf("") }
    var amountText by remember { mutableStateOf("") }
    var type by remember { mutableStateOf(TransactionType.EXPENSE) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(onClick = onBack) {
                Icon(
                    painterResource(R.drawable.ic_left_back),
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(Padding.S16)
        ) {
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = {
                    Text(
                        stringResource(R.string.description)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(Padding.S12))

            OutlinedTextField(
                value = amountText,
                onValueChange = { amountText = it },
                label = {
                    Text(
                        stringResource(R.string.value)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(Padding.S12))

            Row {
                FilterChip(
                    selected = type == TransactionType.EXPENSE,
                    onClick = { type = TransactionType.EXPENSE },
                    label = {
                        Text(
                            stringResource(R.string.expense)
                        )
                    }
                )
                Spacer(Modifier.width(8.dp))
                FilterChip(
                    selected = type == TransactionType.INCOME,
                    onClick = { type = TransactionType.INCOME },
                    label = {
                        Text(
                            stringResource(R.string.revenue)
                        )
                    }
                )
            }

            Spacer(Modifier.height(Padding.S16))

            Button(
                onClick = {
                    val amount = amountText.replace(",", ".").toDoubleOrNull() ?: return@Button
                    viewModel.addTransaction(
                        description = description,
                        amount = amount,
                        type = type,
                        categoryId = null
                    )

                    description = ""
                    amountText = ""
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    stringResource(R.string.save_transaction)
                )
            }
        }
    }
}