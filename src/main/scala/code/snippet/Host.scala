package code.snippet

import net.liftweb.util.Helpers._
import java.net.InetAddress
import net.liftweb.http.S
import net.liftweb.util.{ClearNodes, PassThru}

object Host {
  def render = "*" #> InetAddress.getLocalHost.getHostAddress
}
