package com.example.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.example.example.ui.theme.ExampleTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.activity.result.contract.ActivityResultContracts.TakePicture
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.IntOffset
import com.google.android.material.datepicker.MaterialDatePicker

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme{
                MainScreen()
            }
        }
    }


    private fun showTakeawayDatePicker() {
/**        val date = viewModel.takeawayResponse
        val picker = MaterialDatePicker.Builder.datePicker().build()

        activity?.let {
            picker.show(it.supportFragmentManager, picker.toString())
            picker.addOnPositiveButtonClickListener { selectedDate -> viewModel.onTakeawayResponse(selectedDate)}
        }*/
    }
/**
        private fun showDatePicker(activity: AppCompatActivity?, onDateChange: (Long) -> Unit) {
            val picker =


        }*/

  /**      val date = viewModel.takeawayResponse
  val picker = MaterialDatePicker.Builder.datePicker()
  .setSelection(date)
  .build()
  picker.show(this, picker.toString())
  picker.addOnPositiveButtonClickListener {
  picker.selection?.let { selectedDate ->
  viewModel.onTakeawayResponse(selectedDate)
  }
  }
    }*/
}


/**
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.hilt.navigation.compose.hiltViewModel
import com.kapirti.groupwork.R.drawable as AppIcon
import com.kapirti.groupwork.R.string as AppText
import com.google.android.material.datepicker.MaterialDatePicker
import com.kapirti.groupwork.common.composable.ActionToolbar
import com.kapirti.groupwork.common.composable.BasicField
import com.kapirti.groupwork.common.composable.CardSelector
import com.kapirti.groupwork.common.composable.RegularCardEditor
import com.kapirti.groupwork.common.ext.card
import com.kapirti.groupwork.common.ext.fieldModifier
import com.kapirti.groupwork.common.ext.spacer
import com.kapirti.groupwork.common.ext.toolbarActions
import com.kapirti.groupwork.model.Gender
import com.kapirti.groupwork.model.User
import com.kapirti.groupwork.tokenStringDS
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlin.random.Random

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompleteProfileScreen(
    openAndPopUp: (String, String) -> Unit,
    showAd: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CompleteProfileViewModel = hiltViewModel()
) {
    val user by viewModel.user
        CardEditors(user, viewModel::onBirthdayChange)

@ExperimentalMaterialApi
@Composable
private fun CardEditors(
    user: User,
    onDateChange: (Long) -> Unit
) {
    val activity = LocalContext.current as AppCompatActivity

    RegularCardEditor(AppText.birthday, AppIcon.ic_calendar, user.birthday, Modifier.card()) {
        showDatePicker(activity, onDateChange)


*/