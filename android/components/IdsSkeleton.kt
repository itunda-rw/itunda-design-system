package rw.itunda.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rw.itunda.core.designsystem.theme.Ids

/**
 * Static loading placeholder. Keep geometry identical to the content it replaces.
 * Animation can be layered by a product when motion is appropriate.
 */
@Composable
fun IdsSkeleton(
    modifier: Modifier = Modifier,
    width: Dp = Dp.Unspecified,
    height: Dp = 16.dp,
    cornerRadius: Dp = 8.dp,
) {
    Box(
        modifier = modifier
            .then(if (width != Dp.Unspecified) Modifier.width(width) else Modifier)
            .height(height)
            .background(
                color = Ids.colors.surfaceSoft,
                shape = RoundedCornerShape(cornerRadius),
            ),
    )
}
