package rw.itunda.core.designsystem.components

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Snackbar
import rw.itunda.core.designsystem.theme.Ids

/**
 * Shared transient feedback surface.
 *
 * Use for short-lived confirmation or recovery messages. Important actions and
 * errors must remain available in persistent UI as well; a transient message is
 * not the only source of truth.
 */
@Composable
fun IdsSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(hostState = hostState, modifier = modifier) { data ->
        Snackbar(
            snackbarData = data,
            containerColor = Ids.colors.surface,
            contentColor = Ids.colors.textPrimary,
            actionColor = Ids.colors.brand,
        )
    }
}
