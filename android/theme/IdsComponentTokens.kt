package rw.itunda.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Component-level semantic tokens.
 *
 * These values intentionally reference stable semantic roles rather than raw
 * product colors. Components consume this layer so product themes can override
 * component meaning without forking component implementations.
 */
@Immutable
data class IdsButtonTokens(
    val largeHeight: Dp = 56.dp,
    val mediumHeight: Dp = 48.dp,
    val smallHeight: Dp = 36.dp,
    val largeRadius: Dp = 12.dp,
    val smallRadius: Dp = 10.dp,
    val iconSmallSize: Dp = 14.dp,
    val iconSize: Dp = 18.dp,
    val iconGap: Dp = 6.dp,
)

@Immutable
data class IdsComponentTokens(
    val button: IdsButtonTokens = IdsButtonTokens(),
)

val IdsDefaultComponentTokens = IdsComponentTokens()

val LocalIdsComponentTokens = staticCompositionLocalOf { IdsDefaultComponentTokens }

@Composable
fun idsComponentTokens(): IdsComponentTokens = LocalIdsComponentTokens.current
