package com.vigli.refactoring

data class Movie(val title: String, var priceCode: Int) {
    private var price: Price = when (priceCode) {
        REGULAR -> {
            RegularPrice()
        }
        NEW_RELEASE -> {
            NewReleasePrice()
        }
        CHILDRENS -> {
            ChildrensPrice()
        }
        else -> {
            throw IllegalArgumentException("가격 코드가 잘못되었습니다.")
        }
    }

    fun getCharge(daysRented: Int): Double {
        return price.getCharge(daysRented)
    }

    fun getFrequentRenterPoints(daysRented: Int): Int {
        return price.getFrequentRenterPoints(daysRented)
    }

    companion object {
        const val CHILDRENS = 2
        const val REGULAR = 0
        const val NEW_RELEASE = 1
    }
}
