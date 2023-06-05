package com.vigli.refactoring

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CustomerTest {
    @Test
    fun statement_is_correct() {
        val sut = Customer(
            "vigli",
            mutableListOf(
                Rental(Movie("movie1", Movie.REGULAR), 1),
                Rental(Movie("movie2", Movie.NEW_RELEASE), 2),
                Rental(Movie("movie3", Movie.CHILDRENS), 3)
            )
        )

        val result = sut.statement()

        assertEquals("vigli 고객님의 대여 기록\n" +
                "\tmovie1\t2.0\n" +
                "\tmovie2\t6.0\n" +
                "\tmovie3\t1.5\n" +
                "누적 대여료: 9.5\n" +
                "적립 포인트: 4", result)
    }
}
