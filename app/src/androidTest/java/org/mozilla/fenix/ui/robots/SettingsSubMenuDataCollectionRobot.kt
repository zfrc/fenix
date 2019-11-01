/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuDataCollectionRobot {

    fun verifyUsageAndTechDataLabel() = assertUsageAndTechDataLabel()

    fun verifyUsageAndTechDataDescription() = assertUsageAndTechDataDescription()

    fun verifyExperimentsLabel() = assertExperimentsLabel()

    fun verifyExperimentsDescription() = assertExperimentsDescription()

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

private fun assertUsageAndTechDataLabel() = onView(withText(CoreMatchers.endsWith("Usage and technical data")))
    .check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

private fun assertUsageAndTechDataDescription() = onView(withText(CoreMatchers.endsWith("to help us make Firefox Preview better")))
    .check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

private fun assertExperimentsLabel() = onView(withText(CoreMatchers.endsWith("Experiments")))
    .check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

private fun assertExperimentsDescription() = onView(withText(CoreMatchers.endsWith("Allows Mozilla to install and collect data for experimental features")))
    .check(ViewAssertions.matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

private fun goBackButton() =
    onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
