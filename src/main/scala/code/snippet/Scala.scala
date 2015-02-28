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

  private def append(html:NodeSeq) = "* *+" #> html

  def code(in:NodeSeq):NodeSeq = {
    val bg = in.headOption
      .map(_ \ "@data-bg")
      .map(_.toString)
      .map(bg => if(bg contains "sc") "light" else "dark")
      .headOption.getOrElse("light")

    val html = <pre>
      <code class={s"scala $bg"}>
        <div class="centered">{src("src")}</div>
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
    val src1 = src("src1").split(nl).toList
    val src2 = src("src2").split(nl).toList
    val lines:NodeSeq = src1.zip(src2)
      .map { case (s1, s2) => html(s1, "light") ++ html(s2, "dark") }
      .reduce(_ ++ _) ++ html("", "light") ++ html("", "dark")

    append(<div class="centered zebra">{lines}</div>)
  }
}