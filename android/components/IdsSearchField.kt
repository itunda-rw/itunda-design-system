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

/** Search-specific input with a stable leading icon and optional clear action. */
@Composable
fun IdsSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    searchIcon: ImageVector,
    modifier: Modifier = Modifier,
    placeholder: String = "Search",
    clearIcon: ImageVector? = null,
    onClear: (() -> Unit)? = null,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = true,
        placeholder = { Text(placeholder) },
        leadingIcon = { Icon(searchIcon, contentDescription = "Search") },
        trailingIcon = if (clearIcon != null && onClear != null && value.isNotEmpty()) {
            {
                IconButton(onClick = onClear, enabled = enabled) {
                    Icon(clearIcon, contentDescription = "Clear search")
                }
            }
        } else null,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Ids.colors.brand,
            unfocusedIndicatorColor = Ids.colors.divider,
            cursorColor = Ids.colors.brand,
        ),
    )
}
