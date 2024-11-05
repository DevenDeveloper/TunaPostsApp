package com.deven.post.view.ui.navigation

private const val KEY_SCREEN_NAME = "screen_name"

/**
 * Represents this [Screen] as Map
 */
fun <S : Screen> S.asSavable(): Map<String, String> {
    return when (this) {
        is Screen.Home -> savable<Screen.Home>()
        else -> error("Can't save state for screen: ${this@asSavable}. Reason: Undefined")
    }
}

/**
 * Constructs [Screen] from [savable] map data
 */
fun buildScreenFromSavable(savable: Map<String, String>): Screen {
    return when (val screenName = savable[KEY_SCREEN_NAME]) {
        screenName<Screen.Home>() -> Screen.Home
        else -> error("Can't restore state for screen: $screenName. Reason: Undefined")
    }
}

/**
 * Creates savable Map for screen [S] having entry of [pairs] in the map
 */
private inline fun <reified S : Screen> savable(
    vararg pairs: Pair<String, String>,
) = buildMap<String, String> {
    put(KEY_SCREEN_NAME, screenName<S>())
    putAll(pairs)
}

inline fun <reified SCREEN : Screen> screenName(): String = SCREEN::class.qualifiedName!!
