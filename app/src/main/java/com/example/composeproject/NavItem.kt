package com.example.composeproject

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composeproject.ui.theme.NAV_FAVS
import com.example.composeproject.ui.theme.NAV_FEED
import com.example.composeproject.ui.theme.NAV_HOME
import com.example.composeproject.ui.theme.NAV_PROFILE

sealed class NavItem (
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val navRoute: String
) {
    object Home: NavItem(R.string.home, R.drawable.ic_home, NAV_HOME)
    object Favs: NavItem(R.string.favs, R.drawable.ic_star, NAV_FAVS)
    object Feed: NavItem(R.string.feed, R.drawable.ic_list, NAV_FEED)
    object Profile: NavItem(R.string.profile, R.drawable.ic_person, NAV_PROFILE)
}