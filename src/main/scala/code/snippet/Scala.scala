package code.snippet

import net.liftweb.http.{LiftRules, S}
import net.liftweb.util.Helpers._

import scala.xml.NodeSeq

object Scala {
  def render(in:NodeSeq):NodeSeq = {
    val src = (for {
      name <- S.attr("src")
      code <- LiftRules.loadResourceAsString(s"/scala/$name.scala")
    } yield { code })
      .openOr("// Source not found!!!")

    val bg = in.headOption
      .map(_ \ "@data-bg")
      .map(_.toString)
      .map(bg => if(bg contains "sc") "light" else "dark")
      .headOption.getOrElse("light")

    val html = <pre>
      <code class={s"scala $bg"}>
        <div class="centered">{src}</div>
      </code>
    </pre>

    val transform = "* *+" #> html

    transform(in)
  }
}
