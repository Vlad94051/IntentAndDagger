package ru.tms.myapplication.di

import dagger.Module
import dagger.Provides
import ru.tms.myapplication.data.model.*

@Module
class StubModule {

    @Provides
    fun provideA(d: D) = A(d)

    @Provides
    fun provideB(c: C) = B(c)

    @Provides
    fun provideC(a: A) = C(a)

    @Provides
    fun provideStubUtil(a: A, b: B, c: C, d: D): StubUtil = StubUtilImpl(
        a, b, c, d
    )
}