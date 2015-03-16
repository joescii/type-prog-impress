package code.snippet

import net.liftweb.util.Helpers._
import java.net.InetAddress
import net.liftweb.http.S
import net.liftweb.util.{Props, ClearNodes, PassThru}

object Host {
  val name = {
    val localhost = "localhost:8080"
    val url = Props.get("url", "localhost:8080")
    // This lets it run at localhost while showing the IP so everyone can have the endpoint
    if(url == localhost) InetAddress.getLocalHost.getHostAddress + ":8080"
    else url
  }
  def render = "*" #> name
}
