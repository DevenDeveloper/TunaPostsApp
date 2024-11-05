import SwiftUI
import ComposeApp

@main
struct iosApp: App {

    var body: some Scene {
        WindowGroup {
            App()
        }
        .onAppear {
            let appDelegate = AppDelegate()
            UIApplication.shared.delegate = appDelegate
        }
    }
}