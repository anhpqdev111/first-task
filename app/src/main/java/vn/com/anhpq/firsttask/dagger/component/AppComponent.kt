package vn.com.anhpq.firsttask.dagger.component

import dagger.Component
import vn.com.anhpq.firsttask.dagger.module.CoroutineScopeModule
import vn.com.anhpq.firsttask.dagger.module.NetworkModule
import vn.com.anhpq.firsttask.ui.login.LoginViewModel
import vn.com.anhpq.firsttask.ui.main.MainViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class), (CoroutineScopeModule::class)])
interface AppComponent {
    fun inject(loginViewModel: LoginViewModel)
    fun inject(mainViewModel: MainViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
        fun coroutineScopModule(coroutineScopeModule: CoroutineScopeModule): Builder
    }
}