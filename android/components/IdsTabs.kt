package rw.itunda.core.designsystem.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import rw.itunda.core.designsystem.theme.Ids

/** Compact horizontally-scrollable tab primitive for top-level section switching. */
@Composable
fun IdsTabs(
    labels: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = Ids.layout.screenHorizontal),
    ) {
        labels.forEachIndexed { index, label ->
            Text(
                text = label,
                color = if (index == selectedIndex) Ids.colors.textPrimary else Ids.colors.textSecondary,
                modifier = Modifier
                    .clickable { onSelected(index) }
                    .padding(horizontal = 12.dp, vertical = 12.dp),
            )
        }
    }
}
