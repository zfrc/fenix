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
import org.hamcrest.CoreMatchers.allOf
import org.mozilla.fenix.helpers.click

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuEnhancedTPRobot {

    fun verifyBrowseHeader() = assertBrowseHeader()

    fun verifyBrowseText() = assertBrowseText()

    fun verifyLearnMoreLink() = assertLearnMoreLink()

//    fun verifyEnhancedTrackingProtectionToggle() = assertEnhancedTrackingProtectionToggle()

    fun verifyStandardToggle() = assertStandardToggle()

    fun verifyStandardDescription() = assertStandardDescription()

    fun verifyStrictToggle() = assertStrictToggle()

    fun verifyStrictDescription() = assertStrictDescription()

    fun verifyExceptions() = assertExceptions()

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: SettingsRobot.() -> Unit): SettingsRobot.Transition {
//            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            SettingsRobot().interact()
            return SettingsRobot.Transition()
        }

        fun openExceptions(interact: SettingsSubMenuEnhancedTPExceptionsRobot.() -> Unit): SettingsSubMenuEnhancedTPExceptionsRobot.Transition {
//            mDevice.waitForIdle()
            fun exceptionsButton() = onView(ViewMatchers.withText("Exceptions"))
            exceptionsButton().click()

            SettingsSubMenuEnhancedTPExceptionsRobot().interact()
            return SettingsSubMenuEnhancedTPExceptionsRobot.Transition()
        }
    }
}

private fun assertBrowseHeader() {
    onView(ViewMatchers.withText("Browse without being followed"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertBrowseText() {
    val strBrowseText = "Keep your data to yourself. Firefox Preview protects you from many of the most common trackers that follow what you do online."
    onView(ViewMatchers.withText(strBrowseText))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertLearnMoreLink() {
    onView(ViewMatchers.withText("Learn more"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

// matches multiple views in hierarchy
private fun assertEnhancedTrackingProtectionToggle() {
    onView(ViewMatchers.withText("Enhanced Tracking Protection"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertStandardToggle() {
    onView(ViewMatchers.withText("Standard"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertStandardDescription() {
    val strStandard = "Pages will load normally, but block fewer trackers."
    onView(ViewMatchers.withText(strStandard))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertStrictToggle() {
    onView(ViewMatchers.withText("Strict (Default)"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertStrictDescription() {
    val strStrict = "Stronger tracking protection and faster performance, but some sites may not work properly."
    onView(ViewMatchers.withText(strStrict))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertExceptions() {
    onView(ViewMatchers.withText("Exceptions"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(allOf(ViewMatchers.withContentDescription("Navigate up")))
