package ru.tms.myapplication.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.tms.myapplication.data.NewsApi
import ru.tms.myapplication.data.RetrofitConstants

@Module
class RetrofitModule {

    @Provides
    fun providesGson(): Gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    fun provideRetrofitClient(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(RetrofitConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun providesNewsApi(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)
}