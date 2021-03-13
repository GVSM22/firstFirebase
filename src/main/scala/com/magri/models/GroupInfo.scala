package com.magri.models

import java.time.LocalDate

case class GroupInfo(dateIn: LocalDate, dateOut: LocalDate, status: String) {
  def toBean: GroupInfoClass = {
    val groupInfoClass = new GroupInfoClass
    groupInfoClass.dateIn = dateIn.toString
    groupInfoClass.dateOut = dateOut.toString
    groupInfoClass.status = status
    groupInfoClass
  }
}
