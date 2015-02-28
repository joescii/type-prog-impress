package code.snippet

import net.liftweb.http.{LiftRules, S}
import net.liftweb.util.Helpers._

import scala.xml.NodeSeq

object Scala {
  private def src(attr:String) = (for {
    name <- S.attr(attr)
    code <- LiftRules.loadResourceAsString(s"/scala/$name.scala")
  } yield { code })
    .openOr("// Source not found!!!")

  private def html(src:String, bg:String) = <pre>
    <code class={s"scala $bg"}>
      <div class="centered">{src}</div>
    </code>
  </pre>

  private def append(html:NodeSeq) = "* *+" #> html

  def code(in:NodeSeq):NodeSeq = {
    val bg = in.headOption
      .map(_ \ "@data-bg")
      .map(_.toString)
      .map(bg => if(bg contains "sc") "light" else "dark")
      .headOption.getOrElse("light")

    append(html(src("src"), bg))(in)
  }
}