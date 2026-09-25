package rw.itunda.core.designsystem.theme

import androidx.compose.ui.graphics.Color

/**
 * Itunda Design System primitive color scale.
 *
 * The numbered primitives are kept separate from semantic roles so components
 * depend on meaning (brand, text, surface, danger, etc.) rather than raw values.
 * The canonical primitive source is design-system/tokens/tokens.json.
 *
 * Some primitive values were benchmarked against publicly documented TDS colors
 * during IDS development, but these tokens are maintained as Itunda-owned
 * primitives and must not be treated as a copy of another product's identity.
 */
object IdsColors {
    // GENERATED:BEGIN -- do not hand-edit; regenerate with packages/design-tokens/generate-tokens.js.
    val Grey50 = Color(0xFFF9FAFB)
    val Grey100 = Color(0xFFF2F4F6)
    val Grey200 = Color(0xFFE5E8EB)
    val Grey300 = Color(0xFFD1D6DB)
    val Grey400 = Color(0xFFB0B8C1)
    val Grey500 = Color(0xFF8B95A1)
    val Grey600 = Color(0xFF6B7684)
    val Grey700 = Color(0xFF4E5968)
    val Grey800 = Color(0xFF333D4B)
    val Grey900 = Color(0xFF191F28)

    val Blue50 = Color(0xFFF5FAFF)
    val Blue100 = Color(0xFFE9F3FF)
    val Blue200 = Color(0xFFD1E6FF)
    val Blue300 = Color(0xFF64A8FF)
    val Blue400 = Color(0xFF4593FC)
    val Blue500 = Color(0xFF3182F6)
    val Blue600 = Color(0xFF2272EB)
    val Blue700 = Color(0xFF1B64DA)
    val Blue800 = Color(0xFF1957C2)
    val Blue900 = Color(0xFF194AA6)

    val Red50 = Color(0xFFFFF7F7)
    val Red100 = Color(0xFFFFEDEE)
    val Red200 = Color(0xFFFFDADC)
    val Red300 = Color(0xFFFB8890)
    val Red400 = Color(0xFFF66570)
    val Red500 = Color(0xFFF04452)
    val Red600 = Color(0xFFE42939)
    val Red700 = Color(0xFFD22030)
    val Red800 = Color(0xFFBC1B2A)
    val Red900 = Color(0xFFA51926)

    val Green500 = Color(0xFF04C065)
    val White = Color(0xFFFFFFFF)
    // GENERATED:END

    // Semantic aliases retained for source compatibility. New components should
    // prefer Ids.colors semantic tokens instead of primitive/numbered colors.
    val Gray900 = Grey900
    val Gray800 = Grey800
    val Gray700 = Grey700
    val Gray600 = Grey600
    val Gray500 = Grey500
    val Gray400 = Grey400
    val Gray300 = Grey300
    val Gray200 = Grey200
    val Gray100 = Grey100
    val Gray50 = Grey50
}
