package com.example.howexpensive.ui.screens.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.howexpensive.R
import com.example.howexpensive.ui.components.TransactionCard
import com.example.howexpensive.ui.theme.Padding

@Composable
fun DashboardScreen(
    onAddClick: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text(
                text = stringResource(R.string.actual_balance),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .padding(0.dp, 16.dp)
            )

            Text(
                text = "R$ ${state.balance}",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(Padding.S24))


            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.transactions),
                    style = MaterialTheme.typography.titleMedium
                )

                IconButton (
                    onClick = onAddClick,
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painterResource(R.drawable.ic_add),
                        contentDescription = stringResource(R.string.add_transaction)
                    )
                }
            }


            Spacer(modifier = Modifier.height(Padding.S8))

            LazyColumn {

                items(state.transactions) { transaction ->
                    TransactionCard(
                        transaction,
                        onDeleteClick = { viewModel.deleteTransaction(it) }
                    )
                }
            }
        }
    }
}