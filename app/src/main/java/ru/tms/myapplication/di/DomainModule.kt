package ru.tms.myapplication.di

import dagger.Module
import dagger.Provides
import ru.tms.myapplication.data.IInteractor
import ru.tms.myapplication.data.Interactor
import ru.tms.myapplication.data.NewsApi

@Module
class DomainModule {

    @Provides
    fun provideInteractor(interactor: Interactor): IInteractor =
        interactor
}