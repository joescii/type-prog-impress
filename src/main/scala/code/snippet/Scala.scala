package code.snippet

import net.liftweb.http.{LiftRules, S}
import net.liftweb.util.Helpers._

import scala.xml.NodeSeq

object Scala {
  private def src = (for {
    name <- S.attr("src")
    code <- LiftRules.loadResourceAsString(s"/scala/$name.scala")
  } yield { code })
    .openOr("// Source not found!!!")

  private def append(html:NodeSeq) = "* *+" #> html

  def code(in:NodeSeq):NodeSeq = {
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

    append(html)(in)
  }

  private val nl = System.getProperty("line.separator")

  def html(src:String, bg:String):NodeSeq = <pre>
    <code class={s"scala $bg"}>
      {src}
    </code>
  </pre>

  def diff = {
    val lines:NodeSeq = src.split(nl).toList
      .grouped(2)
      .map { twoLines =>
        html(twoLines(0), "light") ++
        (if(twoLines.size > 1) html(twoLines(1), "dark") else NodeSeq.Empty) }
      .reduce(_ ++ _)
      // Things are a bit off in the browser, and these empty elements straighten out the stripes.
      .++(html("", "light") ++ html("", "dark"))

    append(<div class="centered zebra">{lines}</div>)
  }
}