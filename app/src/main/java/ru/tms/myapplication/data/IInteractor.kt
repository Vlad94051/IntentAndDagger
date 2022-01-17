package ru.tms.myapplication.data

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface IInteractor {
    suspend fun getSource(): SourceResponse
}

class Interactor @Inject constructor(
    private val context: Context,
    private val newsApi: NewsApi
) : IInteractor {

    override suspend fun getSource(): SourceResponse {
        return withContext(Dispatchers.IO) {
           return@withContext newsApi.getSource(
                category = "entertainment",
                language = "en",
                country = "us"
            )
        }
    }
}