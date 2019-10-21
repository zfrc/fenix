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

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuSitePermExceptionsRobot {
    fun verifyNoSiteExceptions() = assertNoSiteExceptions()

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: SettingsSubMenuSitePermissionsRobot.() -> Unit): SettingsSubMenuSitePermissionsRobot.Transition {
            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            SettingsSubMenuSitePermissionsRobot().interact()
            return SettingsSubMenuSitePermissionsRobot.Transition()
        }
    }
}

private fun assertNoSiteExceptions() {
    onView(ViewMatchers.withText("No site exceptions"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
