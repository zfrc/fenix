package org.mozilla.fenix.ext

// BN Imports
import android.content.ClipData
import android.content.ClipboardManager
import androidx.core.content.getSystemService
import mozilla.appservices.places.BookmarkRoot
import mozilla.components.browser.storage.sync.PlacesBookmarksStorage
import mozilla.components.concept.storage.BookmarkNode
import org.mozilla.fenix.R
import android.content.Context

// Test imports
import kotlinx.coroutines.ObsoleteCoroutinesApi
import mozilla.components.support.test.robolectric.testContext
import org.mozilla.fenix.TestApplication
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.mockkStatic
import io.mockk.verify
import io.mockk.every
import io.mockk.Runs
import io.mockk.just

@ObsoleteCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)

class BookmarkNodeTest {
    var mockBookmarkNode: BookmarkNode = mockk(relaxed = true)
    val title = "hello"
    //testContext.getString(R.string.library_bookmarks)
    //val mockContext: Context = mockk()

    @Test
    fun `Set root titles`() {
        val showMobileRootTrue = mapOf("root" to testContext.getString(R.string.library_bookmarks),
                "mobile" to testContext.getString(R.string.library_bookmarks),
                "menu" to testContext.getString(R.string.library_desktop_bookmarks_menu),
                "toolbar" to testContext.getString(R.string.library_desktop_bookmarks_toolbar),
                "unfiled" to testContext.getString(R.string.library_desktop_bookmarks_unfiled))

        val showMobileRootFalse = mapOf("root" to testContext.getString(R.string.library_desktop_bookmarks_root),
                "menu" to testContext.getString(R.string.library_desktop_bookmarks_menu),
                "toolbar" to testContext.getString(R.string.library_desktop_bookmarks_toolbar),
                "unfiled" to testContext.getString(R.string.library_desktop_bookmarks_unfiled))

        // Test with false showMobileRoot boolean
        setRootTitles(testContext, false)
        assertEquals(rootTitles, showMobileRootFalse)

        // Test with true showMobileRoot boolean
        setRootTitles(testContext, true)
        assertEquals(rootTitles, showMobileRootTrue)
    }

    @Test
    fun `Bookmark storage`() {
        assertEquals((testContext.components.core.bookmarksStorage), testContext.bookmarkStorage())
    }

    @Test
    fun `Bookmark node with root title`() {
        // Test return null case
        assertEquals(null.withRootTitle(), null)

        // Test return Bookmark node with root titles title key-  NOT YET WORKING
        rootTitles = mapOf("root" to testContext.getString(R.string.library_bookmarks),
                "menu" to testContext.getString(R.string.library_desktop_bookmarks_menu),
                "toolbar" to testContext.getString(R.string.library_desktop_bookmarks_toolbar))
        verify { mockBookmarkNode.withRootTitle() }
        verify { mockBookmarkNode.copy(title = rootTitles[title]) }
        //assertEquals(mockBookmarkNode.copy(title = rootTitles[title]), mockBookmarkNode.withRootTitle())
    }

}
