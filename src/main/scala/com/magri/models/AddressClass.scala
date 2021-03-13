package com.magri.models

import scala.beans.BeanProperty

class AddressClass {
  @BeanProperty var city: String = _
  @BeanProperty var region: String = _
  def toCase: Address = Address(city, region)
}
