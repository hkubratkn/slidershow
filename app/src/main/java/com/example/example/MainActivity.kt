package com.example.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.example.ui.theme.ExampleTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleTheme {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    val lang = Locale.getDefault().getLanguage()
    val lang1 = Locale.getDefault().getISO3Language()
    val lang2 = Locale.getDefault().country
    val lang3 = Locale.getDefault().getISO3Country()
    val lang4 = Locale.getDefault().getDisplayCountry()
    val lang5 = Locale.getDefault().getDisplayName()
    val lang6 = Locale.getDefault().toString()
    val lang7 = Locale.getDefault().getDisplayLanguage()
    val lang8 = Locale.getDefault().language

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = lang)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang1)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang2)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang3)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang4)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang5)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang6)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang7)
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_10)))
        Text(text = lang8)
    }

}