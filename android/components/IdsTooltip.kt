package rw.itunda.core.designsystem.components

import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import rw.itunda.core.designsystem.theme.Ids

/**
 * Short contextual help for controls whose meaning is not obvious.
 * Prefer visible labels when space permits; tooltip text should not be the only
 * way to discover a critical action.
 */
@Composable
fun IdsTooltip(
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip(
                containerColor = Ids.colors.textPrimary,
                contentColor = Ids.colors.surface,
            ) {
                androidx.compose.material3.Text(text)
            }
        },
        state = androidx.compose.material3.rememberTooltipState(),
        modifier = modifier,
    ) {
        content()
    }
}
