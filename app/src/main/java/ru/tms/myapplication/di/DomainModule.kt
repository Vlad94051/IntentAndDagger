package ru.tms.myapplication.di

import dagger.Module
import dagger.Provides
import ru.tms.myapplication.MainViewModel
import ru.tms.myapplication.data.IInteractor
import ru.tms.myapplication.data.Interactor
import ru.tms.myapplication.data.NewsApi
import ru.tms.myapplication.data.model.StubUtil

@Module
class DomainModule {

    @Provides
    fun provideInteractor(interactor: Interactor): IInteractor =
        interactor

    @Provides
    fun provideViewModel(interactor: Interactor, stubModule: StubUtil): MainViewModel =
        MainViewModel(interactor, stubModule)
}