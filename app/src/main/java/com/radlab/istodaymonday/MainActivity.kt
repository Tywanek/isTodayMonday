package com.radlab.istodaymonday

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.radlab.istodaymonday.ui.theme.IsTodayMondayTheme
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.Year
import java.time.temporal.TemporalAdjusters
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mondayRepository = MondayRepositoryImpl()

        setContent {
            IsTodayMondayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(isTodayMonday = mondayRepository.isTodayMonday())
                }
            }
        }
    }
}

@Composable
fun Greeting(isTodayMonday: Boolean) {
    Column {
        Text(text = "isTodayMonday?")
        if (isTodayMonday) {
            TodayIsMonday()
        } else {
            TodayIsNotMonday()
        }
    }
}

@Composable
fun TodayIsMonday() {
    val image = painterResource(R.drawable.check_mark)
    Column(      modifier = Modifier
        .fillMaxWidth()) {
        Text(
            text = "Yes today is Monday!",
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
        )
        Box {
            Image(
                painter = image,
                contentDescription = null
            )
        }
    }
}

@Composable
fun TodayIsNotMonday() {
    val image = painterResource(R.drawable.check_mark)
    Column() {
        Text(
            text = "No today is not Monday!",
            fontSize = 24.sp,
        )
        Box {
            Image(
                painter = image,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IsTodayMondayTheme {
        Greeting(true)
    }
}