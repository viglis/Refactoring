package com.vigli.refactoring

abstract class Price {
    abstract fun getPriceCode(): Int

    fun getCharge(daysRented: Int): Double {
        var result = 0.0
        when (getPriceCode()) {
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
}

class ChildrensPrice : Price() {
    override fun getPriceCode(): Int {
        return Movie.CHILDRENS
    }
}

class NewReleasePrice : Price() {
    override fun getPriceCode(): Int {
        return Movie.NEW_RELEASE
    }
}

class RegularPrice : Price() {
    override fun getPriceCode(): Int {
        return Movie.REGULAR
    }
}
