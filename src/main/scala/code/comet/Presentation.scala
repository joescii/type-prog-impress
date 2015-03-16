package code.comet


import net.liftweb.actor._
import net.liftweb.http._
import js._
import JsCmds._
import JE._

import scala.xml.NodeSeq

object Presentation extends LiftActor with ListenerManager {
  object Ask
  object Init

  val initialStep = "title"
  var currentStep:String = initialStep

  def createUpdate = currentStep

  override def lowPriority = {
    case Ask => reply(currentStep)
    case Init => this ! initialStep
    case id:String => currentStep = id; updateListeners()
  }
}

class PresentationComet extends CometActor with CometListener {
  override def render = NodeSeq.Empty
  override def registerWith = Presentation

  override def lowPriority = {
    case id:String => partialUpdate(
      Call("window.Presentation.goto", id)
    )
  }
}