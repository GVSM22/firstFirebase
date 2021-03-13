package com.magri.models

import java.time.LocalDate
import scala.beans.BeanProperty

class GroupInfoClass {

  @BeanProperty var dateIn: String = _
  @BeanProperty var dateOut: String = _
  @BeanProperty var status: String = _
  def toCase: GroupInfo = GroupInfo(LocalDate.parse(dateIn), LocalDate.parse(dateOut), status)
}
