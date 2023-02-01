package com.example.example

import android.os.Bundle
import java.text.SimpleDateFormat
import java.util.*
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.model.DateModel
import com.example.example.model.service.FirestoreService
import com.google.firebase.Timestamp
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() /**AppCompatActivity()*/
{

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var date1 = viewModel.chatRow.collectAsState()

            Column() {
                Button(
                    onClick = {
                        viewModel.save()
                    }
                ) {
                    Text(text = "save")
                }

                if (date1.value.date != null) {
                    var formattedDate = date1.value.date!!.seconds
                    val textlast = getDayOfWeek(formattedDate)

                    /**

                    formatStringDate(
                    DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format,
                    DateFormats.DEFAULT_FORMAT.format
                    )

                    }




                    //var date1 = "01-02-2022T07:53:51"

                    /**"2022-02-13T00:10:00"*/



                    var dayMonth = date1
                    dayMonth =
                    dayMonth.convertDefaultWithoutTime(DateFormats.DEFAULT_FORMAT.format)
                    .toString()
                     */


                    Text(text = textlast)
                    Text(text = getMonthFromTimeStamp(formattedDate))
                    Text(text = getYearFromTimeStamp(formattedDate) )
                    Text(text = getDayOfWeekSecond(formattedDate))
                    Text(text = getDayOfWeekThree(formattedDate))
                    Text("cncnncn")
                    Text(getMyTry(formattedDate))

/**
                    var timeAMPM = date1.value.date!!.toDate().toString()
                        timeAMPM = timeAMPM.convertDateToWeekNameYear(
                            DateFormats.DEFAULT_FORMAT.format
                        ).toString()

                    Text(timeAMPM)*/
                    Text(date1.value.date!!.toDate().toString())

                }
            }
        }
    }
    fun getDayOfWeek(timestamp: Long): String {
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timestamp * 1000)
    }
    fun getMonthFromTimeStamp(timestamp: Long): String {
        return SimpleDateFormat("MMM", Locale.ENGLISH).format(timestamp * 1000)
    }
    fun getYearFromTimeStamp(timestamp: Long): String {
        return SimpleDateFormat("yyyy", Locale.ENGLISH).format(timestamp * 1000)
    }
    fun getDayOfWeekSecond(timestamp: Long): String {
        return SimpleDateFormat("EEEE-MMM-yyyy", Locale.ENGLISH).format(timestamp * 1000)
    }
    fun getDayOfWeekThree(timestamp: Long): String {
        return SimpleDateFormat("EEEE-MMM", Locale.ENGLISH).format(timestamp * 1000)
    }
    fun getMyTry(timestamps: Long): String {
        return SimpleDateFormat(DateFormats.DATE_TIME_FORMAT_CUSTOM_FORMAT.format, Locale.ENGLISH).format(timestamps * 1000)
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val firestoreService: FirestoreService
): ViewModel(){

    private val _chatRow = MutableStateFlow<DateModel>(DateModel())
    var chatRow: StateFlow<DateModel> = _chatRow

    init{
        viewModelScope.launch {
            firestoreService.getUser()?.let {
                _chatRow.value = it
            }
        }
    }

    fun save(){
        val date = Timestamp.now()
        viewModelScope.launch {
            firestoreService.save(DateModel(date = date))
        }
    }

}


    /**
                        2 -> {
                            var trimhour = date1
                            trimhour =
                                trimhour.convertDateToYMDFullTimeDate(DateFormats.DEFAULT_FORMAT.format).toString()
                            myText.text = trimhour
                        }
                        3 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToYMDFullTimeDate(DateFormats.DEFAULT_FORMAT.format)
                                .toString()
                            myText.text = timeAMPM
                        }
                        4 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.trimTimeFromDateMDY(
                                DateFormats.DEFAULT_FORMAT.format,
                            ).toString()
                            myText.text = timeAMPM
                        }

                        5 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToDMYFullTimeDate(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                        6 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToYMD(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }

                        7 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToMonthNameYear(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }



                        9 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateMonthName(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                        10 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateCustom(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                        11 -> {
                            var timeAMPM = date1
                            timeAMPM = timeAMPM.convertDateToAmPm(
                                DateFormats.DEFAULT_FORMAT.format
                            ).toString()
                            myText.text = timeAMPM
                        }
                    }
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }

    }
}
*/

fun String.convertDefaultWithoutTime(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DEFAULT_FORMAT_WITHOUT_TIME.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToYMDTime(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_TIME_YY_MM_FULL_TIME_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String?.formatStringDate(inputFormat : String, outputFormat : String) : String {
    return if (this.isNullOrEmpty()){
        ""
    }else{
        val dateFormatter = SimpleDateFormat(inputFormat, Locale.getDefault())
        val date = dateFormatter.parse(this)
        date?.let { SimpleDateFormat(outputFormat, Locale.getDefault()).format(it) }.orEmpty()
    }
}

fun String.convertDateToYMDFullTimeDate(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_TIME_YY_MM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}


fun String.trimTimeFromDateMDY(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val trimmed = SimpleDateFormat(DateFormats.DATE_MM_DD_YY_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { trimmed.format(parsedDate) }
}

fun String.convertDateToDMYFullTimeDate(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.FULL_DATE_TIME_DD_MM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToYMD(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_YY_MM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToMonthNameYear(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_MONTH_OF_YEAR_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToWeekNameYear(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DAY_OF_WEEK_MONTH_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}
fun String.convertDateMonthName(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_MONTH_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateCustom(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat(DateFormats.DATE_TIME_FORMAT_CUSTOM_FORMAT.format, Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}

fun String.convertDateToAmPm(format: String): String? {
    val dateFormat = SimpleDateFormat(format, Locale.getDefault())
    val parsedDate = dateFormat.parse(this)
    val dayMonthFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
    return parsedDate?.let { dayMonthFormat.format(parsedDate) }
}


enum class DateFormats(val format: String) {
    DEFAULT_FORMAT("yyyy-MM-dd'T'HH:mm:ss"), //2021-05-20T11:28:24Z


    DEFAULT_FORMAT_WITHOUT_TIME("yyyy-MM-dd"), //2021-05-20
    DATE_TIME_YY_MM_FORMAT("yyyy-MM-dd'T'HH:mm"), //2021-05-20T11:28
    DATE_TIME_YY_MM_FULL_TIME_FORMAT("yyyy-MM-dd'T'HH:mm:ss"), //2021-05-20T11:28
    DATE_MM_DD_YY_FORMAT("MM-dd-yyyy"), //05-20-2021
    DATE_MM_DD_FORMAT("MMM dd, yyyy"), //May 20, 2021
    FULL_DATE_TIME_DD_MM_FORMAT("dd-MM-yyyy'T'HH:mm:ss"), //2021-05-20T11:28:24
    DATE_YY_MM_FORMAT("yyyy-MM-dd"), //2021-05-20
    DATE_MONTH_OF_YEAR_FORMAT("d MMMM, yyyy"), //20 May, 2021
    DAY_OF_WEEK_MONTH_FORMAT("EEE, d MMM"), //Thu, 20 May
    DATE_MONTH_FORMAT("d MMM"), // 20 MAY
    DATE_TIME_FORMAT_CUSTOM_FORMAT("dd.MM.yyyy' - ' HH:mm:ss"), //21.06.2021 - 10:10:18
    TIME_AM_PM_FORMAT("hh:mm a"), // 10:10:18 hh:mm aa
}