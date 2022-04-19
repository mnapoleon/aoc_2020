fun main() {
  val seatingRows = Utils.getResourceAsText("input_day5.txt")

  var highestSeatId = 0
  val seatList:MutableList<Int> = mutableListOf()
  for (data in seatingRows!!) {
    val row = data.subSequence(0, 7).toString()
      .replace("F", "0")
      .replace("B", "1")
    val seat = data.subSequence(7, 10).toString()
      .replace("R", "1").replace("L", "0")

    val realRow = row.toInt(2)
    val realSeat = seat.toInt(2)


    val thisSeatId = realRow * 8 + realSeat
    if (thisSeatId > highestSeatId) highestSeatId = thisSeatId

    seatList.add(thisSeatId)

    //println("$realRow($row) - $realSeat($seat) - $thisSeatId")
  }
  seatList.sort()
  //println("$highestSeatId")
  for((i, v) in seatList.withIndex()) {
    if (v != seatList[i + 1] - 1) {
      println(v + 1)
      break
    }
  }
}