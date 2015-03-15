package code
package snippet

import net.liftweb.http._
import js._
import JsCmds._
import JE._
import net.liftweb.util.Helpers._
import net.liftweb.util.{PassThru, ClearNodes}
import code.comet.Presentation

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
}

object IfPresenter {
  def render = if(model.Presenter) PassThru else ClearNodes
}

object IfAudience {
  def render = if(model.Presenter) ClearNodes else PassThru
}