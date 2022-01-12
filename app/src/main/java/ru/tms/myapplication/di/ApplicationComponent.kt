package ru.tms.myapplication.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.tms.myapplication.MainActivity


@Component(
    modules = [
        RetrofitModule::class
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




























