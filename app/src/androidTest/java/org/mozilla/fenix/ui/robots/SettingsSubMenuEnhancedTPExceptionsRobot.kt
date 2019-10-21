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
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.hamcrest.CoreMatchers
import org.mozilla.fenix.helpers.TestAssetHelper

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuEnhancedTPExceptionsRobot {

    fun verifyExceptionsDescription() = assertExceptionsDescription()
    fun verifyLearnMoreLink() = assertLearnMoreLink()

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: SettingsSubMenuEnhancedTPRobot.() -> Unit): SettingsSubMenuEnhancedTPRobot.Transition {
            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            SettingsSubMenuEnhancedTPRobot().interact()
            return SettingsSubMenuEnhancedTPRobot.Transition()
        }
    }
}

private fun assertExceptionsDescription() {
    val strExceptions = "Exceptions let you disable tracking protection for selected sites."
    mDevice.wait(Until.findObjects(By.text(strExceptions)), TestAssetHelper.waitingTime)
    onView(ViewMatchers.withText(strExceptions))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertLearnMoreLink() {
    onView(ViewMatchers.withText("Learn more"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
