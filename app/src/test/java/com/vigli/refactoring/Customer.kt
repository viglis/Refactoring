package com.vigli.refactoring

data class Customer(
    val name: String,
    private val rentals: MutableList<Rental>
) {
    fun addRental(rental: Rental) {
        rentals.add(rental)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        var result = "$name 고객님의 대여 기록\n"

        rentals.forEach { rental ->
            // 비디오 종류별 대여료 계산
            val thisAmount = amountFor(rental)

            // 적립 포인트 1 포인트 증가
            frequentRenterPoints++
            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if (rental.movie.priceCode == Movie.NEW_RELEASE &&
                rental.daysRented > 1
            ) {
                frequentRenterPoints++
            }

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t${rental.movie.title}\t$thisAmount\n"
            // 현재까지 누적된 총 대여료
            totalAmount += thisAmount
        }

        // 푸터 행 추가
        result += "누적 대여료: $totalAmount\n"
        result += "적립 포인트: $frequentRenterPoints"
        return result
    }

    private fun amountFor(rental: Rental): Double {
        var thisAmount = 0.0
        when (rental.movie.priceCode) {
            Movie.REGULAR -> {
                thisAmount += 2
                if (rental.daysRented > 2) {
                    thisAmount += (rental.daysRented - 2) * 1.5
                }
            }
            Movie.NEW_RELEASE -> {
                thisAmount += rental.daysRented * 3
            }
            Movie.CHILDRENS -> {
                thisAmount += 1.5
                if (rental.daysRented > 3) {
                    thisAmount += (rental.daysRented - 3) * 1.5
                }
            }
        }
        return thisAmount
    }
}
