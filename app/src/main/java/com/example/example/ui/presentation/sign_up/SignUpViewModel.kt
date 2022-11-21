package com.example.example.ui.presentation.sign_up

import androidx.compose.runtime.mutableStateOf
import com.example.example.domain.Constants.SETTINGS_SCREEN
import com.example.example.domain.Constants.SIGN_UP_SCREEN
import com.example.example.R.string as AppText
import com.example.example.ui.common.ext.isValidEmail
import com.example.example.ui.common.ext.isValidPassword
import com.example.example.ui.common.ext.passwordMatches
import com.example.example.ui.common.snackbar.SnackbarManager
import com.example.example.ui.model.service.AccountService
import com.example.example.ui.model.service.LogService
import com.example.example.ui.presentation.MakeItSoViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService
) : MakeItSoViewModel(logService) {
    var uiState = mutableStateOf(SignUpUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onRepeatPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(repeatPassword = newValue)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        if (!password.isValidPassword()) {
            SnackbarManager.showMessage(AppText.password_error)
            return
        }

        if (!password.passwordMatches(uiState.value.repeatPassword)) {
            SnackbarManager.showMessage(AppText.password_match_error)
            return
        }

        launchCatching {
            accountService.linkAccount(email, password)
            openAndPopUp(SETTINGS_SCREEN, SIGN_UP_SCREEN)
        }
    }
}