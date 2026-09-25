package rw.itunda.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.heightIn
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.VisualTransformation
import rw.itunda.core.designsystem.theme.Ids
import rw.itunda.core.designsystem.theme.idsComponentTokens

/**
 * Shared IDS text input contract.
 *
 * Product screens should use this instead of styling Material3 TextField directly.
 * The wrapper centralizes semantic colors, error/supporting text, keyboard behavior,
 * icon accessibility, multiline behavior, and leading/trailing actions.
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
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    minLines: Int = 1,
    maxLines: Int = if (singleLine) 1 else 5,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val hasError = errorText != null
    val supporting = errorText ?: supportingText

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        readOnly = readOnly,
        singleLine = singleLine,
        minLines = if (singleLine) 1 else minLines,
        maxLines = if (singleLine) 1 else maxLines.coerceAtLeast(minLines),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        isError = hasError,
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        supportingText = supporting?.let { { Text(it, modifier = Modifier.heightIn(min = idsComponentTokens().textField.supportingTextMinHeight)) } },
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
            unfocusedLabelColor = Ids.colors.textSecondary,
            cursorColor = Ids.colors.brand,
            errorLabelColor = Ids.colors.danger,
            focusedSupportingTextColor = if (hasError) Ids.colors.danger else Ids.colors.textSecondary,
            unfocusedSupportingTextColor = if (hasError) Ids.colors.danger else Ids.colors.textSecondary,
            errorSupportingTextColor = Ids.colors.danger,
        ),
    )
}
