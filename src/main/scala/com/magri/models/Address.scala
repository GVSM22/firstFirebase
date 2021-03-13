package com.magri.models

case class Address(city: String, region: String) {
  def toBean: AddressClass = {
    val addressClass = new AddressClass
    addressClass.city = city
    addressClass.region = region
    addressClass
  }
}
