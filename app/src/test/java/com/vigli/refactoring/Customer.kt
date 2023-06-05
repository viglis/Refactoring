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
            // 경우에 따른 적립 포인트 지급 함수를 호출
            frequentRenterPoints += rental.getFrequentRenterPoints()

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t${rental.movie.title}\t${rental.getCharge()}\n"
            // 현재까지 누적된 총 대여료
            totalAmount += rental.getCharge()
        }

        // 푸터 행 추가
        result += "누적 대여료: $totalAmount\n"
        result += "적립 포인트: $frequentRenterPoints"
        return result
    }
}
