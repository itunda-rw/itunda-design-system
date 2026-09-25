package rw.itunda.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import rw.itunda.core.designsystem.theme.Ids

@Composable
fun IdsLoadingState(
    label: String = "Loading",
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.fillMaxWidth().padding(32.dp).semantics { contentDescription = label },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        CircularProgressIndicator(color = Ids.colors.brand)
        Text(label, color = Ids.colors.textSecondary)
    }
}

@Composable
fun IdsEmptyState(
    title: String,
    message: String? = null,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.fillMaxWidth().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(title, color = Ids.colors.textPrimary)
        message?.let { Text(it, color = Ids.colors.textSecondary) }
    }
}

@Composable
fun IdsErrorState(
    title: String,
    message: String? = null,
    retryLabel: String = "Retry",
    onRetry: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.fillMaxWidth().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(title, color = Ids.colors.textPrimary)
        message?.let { Text(it, color = Ids.colors.textSecondary) }
        if (onRetry != null) {
            IdsButton(text = retryLabel, onClick = onRetry, size = IdsButtonSize.Medium)
        }
    }
}
