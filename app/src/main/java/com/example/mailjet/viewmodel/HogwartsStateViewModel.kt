package com.example.mailjet.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mailjet.network.RetrofitBuilder
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class HogwartsStateViewModel : ViewModel() {


    private val _hogwartsDetailsList = mutableStateOf(HogwartsState())
    val hogwartsDetailsList: State<HogwartsState> = _hogwartsDetailsList

    fun getHogwartsDetail() {
        viewModelScope.launch {
            try {
                val apiResponse = RetrofitBuilder.getRetrofitClient().getHogwartsDetails()
                if (apiResponse.isSuccessful) {
                    _hogwartsDetailsList.value =
                        _hogwartsDetailsList.value.copy(studentsDetailsList = apiResponse.body()!!)
                    Log.i(
                        "HogwartsDetailsList",
                        "The value is ${_hogwartsDetailsList.value.studentsDetailsList.size}"
                    )
                } else {
                    Log.i("MailJet", " API failed ${apiResponse.message()}")
                }
            } catch (e: Exception) {
                Log.i("MailJet", e.stackTraceToString())
            } catch (e: SocketTimeoutException) {
                Log.i("exception", e.stackTraceToString())
            }
        }
    }
}