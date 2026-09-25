package rw.itunda.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
private fun idsLightColorScheme(colors: IdsSemanticColors) = lightColorScheme(
    primary = colors.brand,
    onPrimary = colors.onBrand,
    background = colors.background,
    onBackground = colors.textPrimary,
    surface = colors.surface,
    onSurface = colors.textPrimary,
    error = colors.danger,
)

@Composable
private fun idsDarkColorScheme(colors: IdsSemanticColors) = darkColorScheme(
    primary = colors.brand,
    onPrimary = colors.onBrand,
    background = colors.background,
    onBackground = colors.textPrimary,
    surface = colors.surface,
    onSurface = colors.textPrimary,
    error = colors.danger,
)

@Composable
fun IdsTheme(
    darkTheme: Boolean = androidx.compose.foundation.isSystemInDarkTheme(),
    variant: IdsThemeVariant = IdsThemeVariant.Core,
    content: @Composable () -> Unit
) {
    val overrides = variant.overrides()
    val baseSemanticColors = if (darkTheme) IdsDarkSemanticColors else IdsLightSemanticColors
    val semanticColors = baseSemanticColors.withOverrides(overrides)
    val colorScheme = if (darkTheme) idsDarkColorScheme(semanticColors) else idsLightColorScheme(semanticColors)

    CompositionLocalProvider(
        LocalIdsSemanticColors provides semanticColors,
        LocalIdsComponentTokens provides overrides.componentTokens,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
