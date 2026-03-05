package com.example.howexpensive.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.howexpensive.data.local.entity.TransactionEntity
import com.example.howexpensive.ui.theme.Padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.howexpensive.R
import com.example.howexpensive.data.model.TransactionType
import com.example.howexpensive.ui.theme.Colors

@Composable
fun TransactionCard(
    transaction: TransactionEntity, onDeleteClick: (TransactionEntity) -> Unit
) {
    val plusOrMinus = if (transaction.type == TransactionType.EXPENSE) "-" else "+"
    val formattedAmount = "$plusOrMinus R$ ${transaction.amount}"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Padding.S4)
    ) {
        Row(
            modifier = Modifier
                .padding(Padding.S16)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {

                Text(transaction.description)

                Text(
                    text = formattedAmount,
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (transaction.type == TransactionType.EXPENSE) Colors.Red
                    else Colors.Green
                )
            }

            IconButton(onClick = { onDeleteClick(transaction) }) {
                Icon(
                    painterResource(R.drawable.ic_delete),
                    contentDescription = stringResource(R.string.delete_transaction),
                    tint = Colors.Red
                )
            }
        }
    }
}
