package rw.itunda.core.designsystem.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import rw.itunda.core.designsystem.theme.Ids

/**
 * Shared IDS dialog contract.
 *
 * Keep dialogs short and decision-oriented. For complex content prefer a bottom
 * sheet or a dedicated screen rather than creating a second custom modal pattern.
 *
 * Action labels are caller-owned so reusable IDS components never embed
 * non-localized product copy.
 */
@Composable
fun IdsDialog(
    title: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    message: String? = null,
    confirmLabel: String,
    dismissLabel: String? = null,
    onConfirm: () -> Unit,
    confirmEnabled: Boolean = true,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = { Text(title, color = Ids.colors.textPrimary) },
        text = message?.let { { Text(it, color = Ids.colors.textSecondary) } },
        confirmButton = {
            TextButton(onClick = onConfirm, enabled = confirmEnabled) {
                Text(confirmLabel, color = Ids.colors.brand)
            }
        },
        dismissButton = dismissLabel?.let { label ->
            {
                TextButton(onClick = onDismissRequest) {
                    Text(label, color = Ids.colors.textSecondary)
                }
            }
        },
        containerColor = Ids.colors.surface,
    )
}
