package com.vigli.refactoring

data class Rental(
    val movie: Movie,
    val daysRented: Int
) {
    fun getCharge(): Double {
        return movie.getCharge(daysRented)
    }

    fun getFrequentRenterPoints(): Int {
        return movie.getFrequentRenterPoints(daysRented)
    }
}
