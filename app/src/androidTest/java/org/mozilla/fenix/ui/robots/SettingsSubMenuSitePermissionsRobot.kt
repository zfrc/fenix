/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers
import org.mozilla.fenix.helpers.click

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuSitePermissionsRobot {
    fun verifyAutoplay() = assertAutoplay()
    fun verifyAutoplayStatus() = assertAutoplayStatus()
    fun verifyCamera() = assertCamera()
//    fun verifyCameraStatus() = assertCameraStatus()
    fun verifyLocation() = assertLocation()
//    fun verifyLocationStatus() = assertLocationStatus()
    fun verifyMicrophone() = assertMicrophone()
//    fun verifyMicrophoneStatus() = assertMicrophoneStatus()
    fun verifyNotification() = assertNotification()
//    fun verifyNotificationStatus() = assertNotificationStatus()
    fun verifyExceptions() = assertExceptions()

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: SettingsRobot.() -> Unit): SettingsRobot.Transition {
            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            SettingsRobot().interact()
            return SettingsRobot.Transition()
        }

        fun openSubMenuExceptions(interact: SettingsSubMenuSitePermExceptionsRobot.() -> Unit): SettingsSubMenuSitePermExceptionsRobot.Transition {
            mDevice.waitForIdle()
            fun transitionButton() = onView(ViewMatchers.withText("Exceptions"))
            transitionButton().click()
            SettingsSubMenuSitePermExceptionsRobot().interact()
            return SettingsSubMenuSitePermExceptionsRobot.Transition()
        }
    }
}

private fun assertAutoplay() {
    onView(ViewMatchers.withText("Autoplay"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertAutoplayStatus() {
    onView(ViewMatchers.withText("Video and audio blocked"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCamera() {
    onView(ViewMatchers.withText("Camera"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

// private fun assertCameraStatus() {
//     onView(ViewMatchers.withText("Ask to allow"))
//         .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
// }

private fun assertLocation() {
    onView(ViewMatchers.withText("Location"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

// private fun assertLocationStatus() {
//     onView(ViewMatchers.withText("Ask to allow"))
//         .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
// }

private fun assertMicrophone() {
    onView(ViewMatchers.withText("Microphone"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

// private fun assertMicrophoneStatus() {
//     onView(ViewMatchers.withText("Ask to allow"))
//         .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
// }

private fun assertNotification() {
    onView(ViewMatchers.withText("Notification"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertExceptions() {
    onView(ViewMatchers.withText("Exceptions"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
