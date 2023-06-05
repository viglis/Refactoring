package com.vigli.refactoring

data class Customer(
    val name: String,
    private val rentals: MutableList<Rental>
) {
    fun addRental(rental: Rental) {
        rentals.add(rental)
    }

    fun statement(): String {
        var result = "$name 고객님의 대여 기록\n"

        rentals.forEach { rental ->
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t${rental.movie.title}\t${rental.getCharge()}\n"
        }

        // 푸터 행 추가
        result += "누적 대여료: ${getTotalCharge()}\n"
        result += "적립 포인트: ${getTotalFrequentRenterPoints()}"
        return result
    }

    fun htmlStatement(): String {
        var result = "<h1><em>$name</em> 고객님의 대여 기록</h1><p>\n"

        rentals.forEach { rental ->
            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "${rental.movie.title}: ${rental.getCharge()}<br>\n"
        }

        // 푸터 행 추가
        result += "<p>누적 대여료: <em>${getTotalCharge()}</em><p>\n"
        result += "적립 포인트: <em>${getTotalFrequentRenterPoints()}</em><p>"
        return result
    }

    private fun getTotalFrequentRenterPoints(): Int {
        var result = 0
        rentals.forEach { rental ->
            result += rental.getFrequentRenterPoints()
        }
        return result
    }

    private fun getTotalCharge(): Double {
        var result = 0.0
        rentals.forEach { rental ->
            result += rental.getCharge()
        }
        return result
    }
}
