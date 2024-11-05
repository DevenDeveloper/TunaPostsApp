import com.deven.post.di.appModule
import org.koin.core.context.startKoin
import platform.Foundation.NSDictionary
import platform.UIKit.UIApplication
import platform.UIKit.UIApplicationDelegateProtocol
import platform.UIKit.UIResponder
import platform.darwin.NSObject

class AppDelegate : NSObject(), UIApplicationDelegateProtocol {
    override fun application(
        application: UIApplication,
        didFinishLaunchingWithOptions /*launchOptions*/: Map<Any?, *>?
    ): Boolean {
//        startKoin {
//            modules(appModule)
//        }
        return true
    }
}