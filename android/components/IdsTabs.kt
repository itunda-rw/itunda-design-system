package rw.itunda.core.designsystem.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Tab
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import rw.itunda.core.designsystem.theme.Ids

@Composable
fun IdsTabs(
    labels: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (labels.isEmpty()) return

    val safeIndex = selectedIndex.coerceIn(labels.indices)

    ScrollableTabRow(
        selectedTabIndex = safeIndex,
        modifier = modifier,
        containerColor = Ids.colors.surface,
        contentColor = Ids.colors.textPrimary,
        edgePadding = Ids.layout.screenHorizontal,
    ) {
        labels.forEachIndexed { index, label ->
            Tab(
                selected = index == safeIndex,
                onClick = { onSelected(index) },
                modifier = Modifier.defaultMinSize(minHeight = 48.dp),
                text = {
                    androidx.compose.material3.Text(
                        text = label,
                        color = if (index == safeIndex) Ids.colors.textPrimary else Ids.colors.textSecondary,
                    )
                },
            )
        }
    }
}
