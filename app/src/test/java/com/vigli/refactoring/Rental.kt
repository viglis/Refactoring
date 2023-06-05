package com.vigli.refactoring

data class Rental(
    val movie: Movie,
    val daysRented: Int
) {
    fun getCharge(): Double {
        var result = 0.0
        when (movie.priceCode) {
            Movie.REGULAR -> {
                result += 2
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5
                }
            }
            Movie.NEW_RELEASE -> {
                result += daysRented * 3
            }
            Movie.CHILDRENS -> {
                result += 1.5
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5
                }
            }
        }
        return result
    }

    fun getFrequentRenterPoints(): Int {
        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if (movie.priceCode == Movie.NEW_RELEASE &&
            daysRented > 1
        ) {
            return 2
        }
        return 1
    }
}
