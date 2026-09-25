package rw.itunda.core.designsystem.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import rw.itunda.core.designsystem.theme.Ids

/** Standard screen header with semantic surface and optional navigation/action icons. */
@Composable
fun IdsTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector? = null,
    navigationContentDescription: String? = null,
    onNavigationClick: (() -> Unit)? = null,
    actionIcon: ImageVector? = null,
    actionContentDescription: String? = null,
    onActionClick: (() -> Unit)? = null,
) {
    CenterAlignedTopAppBar(
        title = { Text(title, color = Ids.colors.textPrimary) },
        modifier = modifier,
        navigationIcon = if (navigationIcon != null && onNavigationClick != null) {
            {
                IconButton(onClick = onNavigationClick) {
                    Icon(navigationIcon, contentDescription = navigationContentDescription)
                }
            }
        } else { {} },
        actions = if (actionIcon != null && onActionClick != null) {
            {
                IconButton(onClick = onActionClick) {
                    Icon(actionIcon, contentDescription = actionContentDescription)
                }
            }
        } else { {} },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Ids.colors.background,
            titleContentColor = Ids.colors.textPrimary,
        ),
    )
}
