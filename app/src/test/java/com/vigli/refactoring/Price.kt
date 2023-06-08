package com.vigli.refactoring

abstract class Price {
    abstract fun getPriceCode(): Int

    abstract fun getCharge(daysRented: Int): Double

    open fun getFrequentRenterPoints(daysRented: Int): Int {
        return 1
    }
}

class ChildrensPrice : Price() {
    override fun getPriceCode(): Int {
        return Movie.CHILDRENS
    }

    override fun getCharge(daysRented: Int): Double {
        var result = 1.5
        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5
        }
        return result
    }
}

class NewReleasePrice : Price() {
    override fun getPriceCode(): Int {
        return Movie.NEW_RELEASE
    }

    override fun getCharge(daysRented: Int): Double {
        return daysRented * 3.0
    }

    override fun getFrequentRenterPoints(daysRented: Int): Int {
        return if (daysRented > 1) {
            2
        } else {
            1
        }
    }
}

class RegularPrice : Price() {
    override fun getPriceCode(): Int {
        return Movie.REGULAR
    }

    override fun getCharge(daysRented: Int): Double {
        var result = 2.0
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5
        }
        return result
    }
}
