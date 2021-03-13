package com.magri

import com.magri.models.User.create
import com.magri.models.{Address, GroupInfo, User}

import java.time.LocalDate

object Main extends App {

  val teste = User("Giacomo",
    GroupInfo(LocalDate.now, LocalDate.now.plusDays(1), "brabo").toBean,
    Address("Campinas", "SP").toBean
  )

  create(teste)

}
