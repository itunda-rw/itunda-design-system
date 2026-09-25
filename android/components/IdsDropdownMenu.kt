package rw.itunda.core.designsystem.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import rw.itunda.core.designsystem.theme.Ids

/**
 * Shared IDS menu primitive.
 *
 * Use for short contextual choices. Keep destructive or high-consequence actions
 * visually and semantically distinct at the product level; use a dialog when a
 * choice needs confirmation rather than hiding that decision inside a menu.
 *
 * The item API keeps the interaction target owned by the menu item itself, while
 * allowing optional trailing content for shortcuts or status indicators.
 */
@Composable
fun IdsDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<String>,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: (Int) -> Boolean = { true },
    trailingContent: (@Composable RowScope.(Int) -> Unit)? = null,
) {
    if (items.isEmpty()) return

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
    ) {
        items.forEachIndexed { index, label ->
            DropdownMenuItem(
                text = { Text(label, color = Ids.colors.textPrimary) },
                onClick = {
                    onItemSelected(index)
                    onDismissRequest()
                },
                enabled = enabled(index),
                trailingIcon = trailingContent?.let { content ->
                    { content(index) }
                },
            )
        }
    }
}
