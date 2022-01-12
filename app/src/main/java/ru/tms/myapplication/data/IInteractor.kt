package ru.tms.myapplication.data

import android.content.Context
import javax.inject.Inject

interface IInteractor

class Interactor @Inject constructor(
    val context: Context,
    val newsApi: NewsApi): IInteractor