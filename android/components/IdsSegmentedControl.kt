package rw.itunda.core.designsystem.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
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
fun IdsSegmentedControl(
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
            Surface(
                onClick = { onSelected(index) },
                color = if (isSelected) Ids.colors.brand else Ids.colors.surfaceSoft,
                modifier = Modifier
                    .semantics {
                        selected = isSelected
                        role = Role.Tab
                    }
                    .padding(end = 8.dp),
            ) {
                Text(
                    text = label,
                    color = if (isSelected) Ids.colors.onBrand else Ids.colors.textPrimary,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                )
            }
        }
    }
}
