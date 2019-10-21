/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.endsWith
import org.mozilla.fenix.R
import org.mozilla.fenix.helpers.click

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuDeleteBrowsingDataOnQuitRobot {
    fun enableDeleteBrowsingDataOnQuit() {
        onView(withId(android.R.id.switch_widget)).click()
    }

    fun verifyDeleteBrowsingDataOnQuitHeader() = assertDeleteBrowsingDataOnQuitHeader()

    fun verifyDeleteBrowsingDataOnQuitDescription() = assertDeleteBrowsingDataOnQuitDescription()

    fun verifyOpenTabsLabel() = assertOpenTabsLabel()

    fun verifyBrowsingHistoryLabel() = assertBrowsingHistoryLabel()

    fun verifyCookiesLabel() = assertCookiesLabel()

    fun verifyCookiesLabelDescription() = assertCookiesLabelDescription()

    fun verifyCachedImagesAndFiles() = assertCachedImagesAndFiles()

    fun verifyCachedImagesAndFilesDescription() = assertCachedImagesAndFilesDescription()

    fun verifySitePermissionsLabel() = assertSitePermissionsLabel()

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

private fun assertDeleteBrowsingDataOnQuitHeader() {
    onView(allOf(ViewMatchers.withText("Delete browsing data on quit"), withId(R.id.title)))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertDeleteBrowsingDataOnQuitDescription() {
    val strMatchText = "Automatically deletes browsing data when you select \"Quit\" from the main menu"
    onView(ViewMatchers.withText(strMatchText))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertOpenTabsLabel() {
    onView(ViewMatchers.withText("Open Tabs"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertBrowsingHistoryLabel() {
    onView(ViewMatchers.withText("Browsing history"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCookiesLabel() {
    onView(ViewMatchers.withText("Cookies"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCookiesLabelDescription() {
    onView(ViewMatchers.withText(endsWith("be logged out of most sites")))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCachedImagesAndFiles() {
    onView(ViewMatchers.withText("Cached images and files"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCachedImagesAndFilesDescription() {
    onView(ViewMatchers.withText("Frees up storage space"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertSitePermissionsLabel() {
    onView(ViewMatchers.withText("Site permissions"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
