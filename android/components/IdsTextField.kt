package rw.itunda.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import rw.itunda.core.designsystem.theme.Ids

/**
 * Shared IDS text input contract.
 *
 * Product screens should use this instead of styling Material3 TextField directly.
 * The wrapper centralizes semantic colors, error behavior, supporting text,
 * accessibility labels, and leading/trailing actions.
 */
@Composable
fun IdsTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    supportingText: String? = null,
    errorText: String? = null,
    leadingIcon: ImageVector? = null,
    leadingContentDescription: String? = null,
    trailingIcon: ImageVector? = null,
    trailingContentDescription: String? = null,
    onTrailingIconClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    singleLine: Boolean = true,
) {
    val hasError = errorText != null
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = singleLine,
        isError = hasError,
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        supportingText = (errorText ?: supportingText)?.let { { Text(it) } },
        leadingIcon = leadingIcon?.let { icon ->
            { Icon(icon, contentDescription = leadingContentDescription) }
        },
        trailingIcon = trailingIcon?.let { icon ->
            {
                if (onTrailingIconClick != null) {
                    IconButton(onClick = onTrailingIconClick, enabled = enabled) {
                        Icon(icon, contentDescription = trailingContentDescription)
                    }
                } else {
                    Icon(icon, contentDescription = trailingContentDescription)
                }
            }
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Ids.colors.brand,
            unfocusedIndicatorColor = Ids.colors.divider,
            errorIndicatorColor = Ids.colors.danger,
            focusedLabelColor = Ids.colors.brand,
            cursorColor = Ids.colors.brand,
            errorLabelColor = Ids.colors.danger,
        ),
    )
}
