package com.secui.healthone.ui.sleep

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.secui.healthone.data.Sleep.SleepRecord

@Composable
fun CustomSleepGoal(
    selectedSleepTime: MutableState<String>,
    selectedWakeTime: MutableState<String>,
    sleepRecords: MutableList<SleepRecord>,
    buttonCheck: MutableState<Boolean>
) {
    val sleepDate = remember { mutableStateOf("") }
    val wakeDate = remember { mutableStateOf("") }
    val sleepTime = remember { mutableStateOf("") }
    val wakeTime = remember { mutableStateOf("") }
    val sleepDuration = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimePickerRow(sleepDate, sleepTime, selectedSleepTime, buttonCheck)
        NowPickerRow(wakeTime, wakeDate)

        val sleepAngle = sleepTime.value.takeIf { it.isNotEmpty() }?.let {
            calculateAngleFromTime(it)
        } ?: 0f

        val wakeAngle = wakeTime.value.takeIf { it.isNotEmpty() }?.let {
            calculateAngleFromTime(it)
        } ?: 0f

        val context = LocalContext.current
        LaunchedEffect(sleepTime.value, wakeTime.value) {
            if (sleepTime.value.isNotEmpty() && wakeTime.value.isNotEmpty()) {
                selectedSleepTime.value = "${sleepDate.value} ${sleepTime.value}"
                selectedWakeTime.value = "${wakeDate.value} ${wakeTime.value}"
                calculateSleepDuration(sleepDate, wakeDate, sleepTime, wakeTime, sleepDuration, context)
            }
        }

        Text(
            text = "수면 시간 : ${sleepDuration.value}",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        SleepTimeClock(sleepRecords = sleepRecords)
    }
}
