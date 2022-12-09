package com.example.robolectrictestexample

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.robolectric.RobolectricTestRunner



@RunWith(RobolectricTestRunner::class)
class TestFragmentTest {

    @Mock
    private lateinit var repository: TestRepository

    private lateinit var viewmodel: TestViewModel
    private val productData = listOf(
        Product("Papa", "5"),
        Product("Arroz", "8")
    )


    @get:Rule
    public val rule = MockitoJUnit.rule()

    @Test
    fun `when fragment is created should fill recyclerview`() {
        val scenario = launchFragmentInContainer<TestFragment>()
        scenario.onFragment {}
        `when`(repository.getProducts()).thenReturn(productData)
        onView(withId(R.id.btnGetProducts)).perform(click())
        onView(withId(R.id.rvProducts)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))


    }


}