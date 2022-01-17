package ru.tms.myapplication.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.tms.myapplication.MainActivity
import ru.tms.myapplication.ShareActivity


@Component(
    modules = [
        RetrofitModule::class,
        DomainModule::class,
        StubModule::class
    ]
)
interface ApplicationComponent {
    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): ApplicationComponent
    }
}




























