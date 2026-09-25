package rw.itunda.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Derived theme support for Itunda product surfaces.
 *
 * Variants share the same component implementations and foundation tokens.
 * Product-specific branding is expressed as semantic overrides instead of
 * duplicated components.
 */
enum class IdsThemeVariant {
    Core,
    Client,
    Business,
    Developer,
}

@Immutable
data class IdsThemeOverrides(
    val brand: Color? = null,
    val onBrand: Color? = null,
    val textBrand: Color? = null,
    val componentTokens: IdsComponentTokens = IdsDefaultComponentTokens,
)

fun IdsThemeVariant.overrides(): IdsThemeOverrides = when (this) {
    IdsThemeVariant.Core -> IdsThemeOverrides()
    IdsThemeVariant.Client -> IdsThemeOverrides()
    IdsThemeVariant.Business -> IdsThemeOverrides()
    IdsThemeVariant.Developer -> IdsThemeOverrides()
}

fun IdsSemanticColors.withOverrides(overrides: IdsThemeOverrides): IdsSemanticColors =
    copy(
        brand = overrides.brand ?: brand,
        onBrand = overrides.onBrand ?: onBrand,
        textBrand = overrides.textBrand ?: textBrand,
    )
