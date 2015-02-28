package code.snippet

import net.liftweb.http.S
import net.liftweb.util.{ClearNodes, PassThru}

object Browser {
  def isFirefox    = if(S.request.map(_.isFirefox).openOr(false)) PassThru else ClearNodes
  def isNotFirefox = if(S.request.map(_.isFirefox).openOr(false)) ClearNodes else PassThru
}
