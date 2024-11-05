import com.deven.post.di.appModule
import org.koin.core.context.startKoin

object KoinApp {
    private var isInitialized = false

    fun initKoin() {
        if (!isInitialized) {
            startKoin {
                modules(appModule)
            }
            isInitialized = true
        }
    }
}