package rw.itunda.core.designsystem.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import rw.itunda.core.designsystem.theme.Ids

data class IdsNavigationItem(
    val label: String,
    val icon: ImageVector,
    val contentDescription: String? = label,
)

/** Shared bottom navigation with semantic IDS colors and accessible labels. */
@Composable
fun IdsNavigationBar(
    items: List<IdsNavigationItem>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Ids.colors.surface,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedIndex,
                onClick = { onSelected(index) },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription,
                    )
                },
                label = { Text(item.label) },
            )
        }
    }
}
