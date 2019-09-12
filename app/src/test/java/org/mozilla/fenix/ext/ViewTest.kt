package org.mozilla.fenix.ext

import android.graphics.Rect
import android.view.TouchDelegate
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import mozilla.components.support.ktx.android.util.dpToPx
import org.junit.Test
import org.junit.Before
import org.junit.runner.RunWith
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.spyk
import io.mockk.verify
import io.mockk.every
import kotlinx.coroutines.ObsoleteCoroutinesApi
import androidx.core.content.ContextCompat
import android.content.Context
import mozilla.components.support.test.robolectric.testContext
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.mozilla.fenix.TestApplication
import io.mockk.Runs
import io.mockk.just
import org.robolectric.Shadows.shadowOf
import org.robolectric.util.ReflectionHelpers
// For layouts
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.os.Bundle

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class ViewTest {

    @Test
    fun testIncreaseTapArea() {
       // val mockView:View = mockk(relaxed=true)
        //val mockView2 = spyk(View(testContext))
        //mockkStatic(View::class)
       // mockkStatic(ViewParent::class)
       // mockkStatic(ViewGroup::class)
       // val mockParent: ViewParent = mockk(relaxed=true)
        //val mockParent = spyk(ViewParent())
       // val mockGroup: ViewGroup = mockk(relaxed=true)
        //mockGroup.addView(mockView)

        //Let's try  with layouts
        //val inflateView: LinearLayout = mockk(relaxed=true)
        //inflateView.addView(mockView)

       // every { (mockView.getParent()) } answers {(mockParent.getParent())}
       // every {mockView.parent} returns mockGroup
       // val mockParent = mockView2 as ViewParent
        //every {mockView.post({println("hello world")})} returns true

        //every {(((mockView.getParent().hint(ViewParent::class)) as View).hint(View::class))} returns mockView2
       // every {(ViewGroup(testContext) as View)} answers {mockView2}

        //val myView = mockk<View> {every { myView.getParent() } just Runs}

        //myView.getParent()

        //Robolectic shadow attempt
        val view = View(testContext)
        shadowOf(view).setMyParent(ReflectionHelpers.createNullProxy(ViewParent::class.java))


        //val mockParent = MockViewParent(testContext)
        //every {(mockView.getParent())} returns ViewParent()
        //every {mockGroup as View} returns mockView

        view.increaseTapArea(4)
        verify {view.increaseTapArea(4)}
        //verify { mockView.parent.setTouchDelegate() }

    }
}

