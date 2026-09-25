package rw.itunda.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class IdsSemanticColors(
    val background: Color,
    val surface: Color,
    val surfaceSoft: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val brand: Color,
    val onBrand: Color,
    val textBrand: Color,
    val divider: Color,
    val chip: Color,
    val pressed: Color,
    val success: Color,
    val successTint: Color,
    val warning: Color,
    val warningTint: Color,
    val danger: Color,
    val dangerTint: Color,
    val iconPrimary: Color,
    val iconSecondary: Color,
    val shadow: Color,
)

val IdsLightSemanticColors = IdsSemanticColors(
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    surfaceSoft = Color(0xFFF2F4F6),
    textPrimary = Color(0xFF191F28),
    textSecondary = Color(0xFF4E5968),
    textTertiary = Color(0xFF636E7C),
    brand = Color(0xFF1F78FF),
    onBrand = Color(0xFFFFFFFF),
    textBrand = Color(0xFF1769D8),
    divider = Color(0xFFE5E8EB),
    chip = Color(0xFFF2F4F6),
    pressed = Color(0xFFEEF0FF),
    success = Color(0xFF05804A),
    successTint = Color(0xFFF5FAFF),
    warning = Color(0xFFFFA000),
    warningTint = Color(0xFFFFF4D6),
    danger = Color(0xFFF04452),
    dangerTint = Color(0xFFFFECEB),
    iconPrimary = Color(0xFF2C3643),
    iconSecondary = Color(0xFF6B7684),
    shadow = Color(0x14000000),
)

val IdsDarkSemanticColors = IdsSemanticColors(
    background = Color(0xFF17171C),
    surface = Color(0xFF202027),
    surfaceSoft = Color(0xFF2C2C35),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFF989EAA),
    textTertiary = Color(0xFF848A96),
    brand = Color(0xFF4F91FF),
    onBrand = Color(0xFFFFFFFF),
    textBrand = Color(0xFF4F91FF),
    divider = Color(0xFF3C3C47),
    chip = Color(0xFF2C2C35),
    pressed = Color(0xFF2B2C52),
    success = Color(0xFF20D394),
    successTint = Color(0xFF10321F),
    warning = Color(0xFFFFC24C),
    warningTint = Color(0xFF3A2E10),
    danger = Color(0xFFFF6B7A),
    dangerTint = Color(0xFF3A1418),
    iconPrimary = Color(0xFFE8EAED),
    iconSecondary = Color(0xFF989EAA),
    shadow = Color(0x40000000),
)

val LocalIdsSemanticColors = staticCompositionLocalOf { IdsLightSemanticColors }

object Ids {
    val colors: IdsSemanticColors
        @Composable get() = LocalIdsSemanticColors.current

    val layout: IdsLayout
        get() = IdsLayout
}
