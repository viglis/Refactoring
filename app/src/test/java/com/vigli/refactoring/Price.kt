package com.vigli.refactoring

abstract class Price {
    abstract fun getPriceCode(): Int
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
