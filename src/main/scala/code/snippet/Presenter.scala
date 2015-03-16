package code
package snippet

import net.liftweb.http._
import js._
import JsCmds._
import JE._
import net.liftweb.util.Helpers._
import net.liftweb.util.{PassThru, ClearNodes}
import code.comet.Presentation

import scala.xml.NodeSeq

/**
 * Created by jbarnes on 10/27/2014.
 */
object Presenter {
  def render = if(model.Presenter) "*" #> Script(
    JsCrVar("PresenterApi", JsObj()) &
      SetExp(JsVar("PresenterApi.goto"), AnonFunc("id", SHtml.ajaxCall(JsVar("id"), {(id:String) =>
        Presentation ! id
      })))
  ) else ClearNodes

  private lazy val passcode:String = {
    val jvmProp = Option(System.getProperty("presentera.passcode"))
    val envProp = Option(System.getenv("presentera_passcode"))
    val default = Some("PresenteraMetal!")

    List(jvmProp, envProp, default).flatten.head
  }

  def login(in:NodeSeq):NodeSeq = {
    for {
      r <- S.request if r.post_? // make sure it's a post
      p <- S.param("passcode")
    } {
      if(p == passcode) {
        model.Presenter(true)
        Presentation ! Presentation.Init
        S.redirectTo("/")
      }
    }

    in
  }
}

object IfPresenter {
  def render = if(model.Presenter) PassThru else ClearNodes
}

object IfAudience {
  def render = if(model.Presenter) ClearNodes else PassThru
}