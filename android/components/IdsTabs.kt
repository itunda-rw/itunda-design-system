package rw.itunda.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
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
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = Ids.layout.screenHorizontal),
    ) {
        labels.forEachIndexed { index, label ->
            val isSelected = index == selectedIndex
            Text(
                text = label,
                color = if (isSelected) Ids.colors.textPrimary else Ids.colors.textSecondary,
                modifier = Modifier
                    .clickable { onSelected(index) }
                    .semantics {
                        selected = isSelected
                        role = Role.Tab
                    }
                    .padding(horizontal = 12.dp, vertical = 12.dp),
            )
        }
    }
}
