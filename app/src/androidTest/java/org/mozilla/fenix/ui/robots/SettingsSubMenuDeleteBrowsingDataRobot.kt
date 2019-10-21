/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.mozilla.fenix.R

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuDeleteBrowsingDataRobot {

    fun verifyOpenTabs() = assertOpenTabs()

    fun verifyOpenTabsCount() = assertOpenTabsCount()

    fun verifyBrowsingHistory() = assertBrowsingHistory()

    fun verifyBrowsingHistoryCount() = assertBrowsingHistoryCount()

    fun verifyCollections() = assertCollections()

    fun verifyCollectionsCount() = assertCollectionsCount()

    fun verifyCookies() = assertCookies()

    fun verifyCookiesDescription() = assertCookiesDescription()

    fun verifyCached() = assertCached()

    fun verifyCachedDescription() = assertCachedDescription()

    fun verifySitePermissions() = assertSitePermissions()

    fun verifyDeleteBrowsingDataButton() = assertDeleteBrowsingDataButton()

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: SettingsRobot.() -> Unit): SettingsRobot.Transition {
            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            SettingsRobot().interact()
            return SettingsRobot.Transition()
        }
    }
}

private fun assertOpenTabs() {
    onView(withText("Open Tabs"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertOpenTabsCount() {
    onView(withText("0 tabs"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertBrowsingHistory() {
    onView(withText("Browsing history and site data"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertBrowsingHistoryCount() {
    onView(withText("0 addresses"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertCollections() {
    onView(withText("Collections"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertCollectionsCount() {
    onView(withText("0 collections"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertCookies() {
    onView(withText("Cookies"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertCookiesDescription() {
    val strMatchText = "logged out of most sites"
    onView(withText(CoreMatchers.endsWith(strMatchText)))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertCached() {
    onView(withText("Cached images and files"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertCachedDescription() {
    onView(withText("Frees up storage space"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertSitePermissions() {
    onView(withText("Site permissions"))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertDeleteBrowsingDataButton() {
    val strMatchText = "Delete browsing data"
    onView(allOf(withText(strMatchText), withId(R.id.delete_data)))
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(CoreMatchers.allOf(withContentDescription("Navigate up")))
