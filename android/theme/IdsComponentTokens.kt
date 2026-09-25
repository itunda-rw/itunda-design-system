package rw.itunda.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Component-level semantic tokens.
 *
 * Components consume this layer instead of embedding geometry values so derived
 * product themes can evolve component behavior without forking implementations.
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
data class IdsCardTokens(
    val radius: Dp = 12.dp,
    val borderWidth: Dp = 1.dp,
)

@Immutable
data class IdsBottomSheetTokens(
    val radius: Dp = 16.dp,
    val dragHandleWidth: Dp = 36.dp,
    val dragHandleHeight: Dp = 4.dp,
    val dragHandleTopPadding: Dp = 10.dp,
    val dragHandleBottomPadding: Dp = 6.dp,
)

@Immutable
data class IdsNavigationBarTokens(
    val itemMinHeight: Dp = 56.dp,
)

@Immutable
data class IdsTextFieldTokens(
    val supportingTextMinHeight: Dp = 20.dp,
)

@Immutable
data class IdsComponentTokens(
    val button: IdsButtonTokens = IdsButtonTokens(),
    val card: IdsCardTokens = IdsCardTokens(),
    val bottomSheet: IdsBottomSheetTokens = IdsBottomSheetTokens(),
    val navigationBar: IdsNavigationBarTokens = IdsNavigationBarTokens(),
    val textField: IdsTextFieldTokens = IdsTextFieldTokens(),
)

val IdsDefaultComponentTokens = IdsComponentTokens()

val LocalIdsComponentTokens = staticCompositionLocalOf { IdsDefaultComponentTokens }

@Composable
fun idsComponentTokens(): IdsComponentTokens = LocalIdsComponentTokens.current
