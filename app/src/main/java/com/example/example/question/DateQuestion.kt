package com.example.example.question

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.example.QuestionWrapper
import com.example.example.simpleDateFormatPattern
import com.example.example.ui.theme.slightlyDeemphasizedAlpha
import com.example.example.util.getDefaultDateInMillis
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

@Composable
fun DateQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    dateInMillis: Long?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    QuestionWrapper(
        titleResourceId = titleResourceId,
        directionsResourceId = directionsResourceId,
        modifier = modifier,
    ) {
        // All times are stored in UTC, so generate the display from UTC also
        val dateFormat = SimpleDateFormat(simpleDateFormatPattern, Locale.getDefault())
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        val dateString = dateFormat.format(dateInMillis ?: getDefaultDateInMillis())

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
                    .copy(alpha = slightlyDeemphasizedAlpha),
            ),
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .height(54.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)),
        ) {
            Text(
                text = dateString,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.8f)
            )
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            )
        }
    }
}