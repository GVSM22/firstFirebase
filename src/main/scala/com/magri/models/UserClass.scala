package com.magri.models

import scala.beans.BeanProperty

class UserClass {

  @BeanProperty var name: String = _
  @BeanProperty var groupInfo: GroupInfoClass = _
  @BeanProperty var address: AddressClass = _

  def toCase: User = User(name, groupInfo, address)
}
