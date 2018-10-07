package com.emlakjet.interview

import com.emlakjet.interview.common.TEST_URL
import com.emlakjet.interview.network.ApiService
import com.emlakjet.interview.util.Validator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun retrofitTest() {
        assertNotEquals(ApiService.factory(), null)
    }

    @Test
    fun testURLIsValid() {
        assert(Validator.isURL(TEST_URL))
    }
}
