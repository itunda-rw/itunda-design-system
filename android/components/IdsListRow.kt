package rw.itunda.core.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.role
import androidx.compose.ui.unit.dp
import rw.itunda.core.designsystem.theme.Ids

/**
 * Standard single-row navigation/action pattern.
 *
 * Long titles remain flexible; the trailing affordance is kept independent so
 * localization and large text do not force a fixed-width text block.
 *
 * A clickable row exposes one semantic action target and keeps decorative icons
 * out of the accessibility tree when their content descriptions are omitted.
 */
@Composable
fun IdsListRow(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    leadingIcon: ImageVector? = null,
    leadingContentDescription: String? = null,
    trailingIcon: ImageVector? = null,
    trailingContentDescription: String? = null,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    val rowModifier = modifier
        .fillMaxWidth()
        .then(
            if (onClick != null) {
                Modifier
                    .clickable(
                        enabled = enabled,
                        role = Role.Button,
                        onClick = onClick,
                    )
                    .semantics { role = Role.Button }
            } else {
                Modifier
            },
        )
        .padding(horizontal = Ids.layout.screenHorizontal, vertical = 14.dp)

    Row(
        modifier = rowModifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = leadingContentDescription,
                tint = Ids.colors.iconPrimary,
                modifier = Modifier.size(24.dp),
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = if (leadingIcon != null) 12.dp else 0.dp),
        ) {
            Text(title, color = Ids.colors.textPrimary)
            if (subtitle != null) {
                Text(subtitle, color = Ids.colors.textSecondary)
            }
        }
        if (trailingIcon != null) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = trailingContentDescription,
                tint = Ids.colors.iconSecondary,
                modifier = Modifier.size(20.dp),
            )
        }
    }
}
