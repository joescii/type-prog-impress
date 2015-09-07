package code.snippet

import net.liftweb.http.{LiftRules, S}
import net.liftweb.util.Helpers._

import scala.util.Try
import scala.xml.NodeSeq

object Code {
  private val newline = System.getProperty("line.separator")

  private def src = (for {
    name <- S.attr("src")
    code <- LiftRules.loadResourceAsString(name)
  } yield {
    val lines = code.split("(?s)\r?\n").toList
    val range = firstLine.map { first =>
      val last = lastLine.getOrElse(first)
      lines
        .drop(first - 1)
        .take(last - first + 1)
    }.getOrElse(lines)
    val trimmed = trimIndentation(range)
    trimmed.mkString(newline)
  }).openOr("// Source not found!!!")

  private def lang = S.attr("src").map(_.split("\\.").last match {
    case "js" => "javascript"
    case other => other
  }).openOr("")

  private def lineParse(which:Array[String] => String) = S.attr("l").toOption.flatMap( l =>
    Try(which(l.split("-")).toInt).toOption
  )
  private def firstLine = lineParse(_.head)
  private def lastLine  = lineParse(_.last)

  private def append(html:NodeSeq) = "* *+" #> html

  def render(in:NodeSeq):NodeSeq = {
    val bg = in.headOption
      .map(_ \ "@data-bg")
      .map(_.toString)
      .map(bg => if(bg contains "sc") "light" else "dark")
      .headOption.getOrElse("light")

    val html = <pre>
      <code class={s"$lang $bg"}>
        <div>
          {src}
        </div>
      </code>
    </pre>

    append(html)(in)
  }

  private val CodeRegex = """(\s*).*?""".r
  private def spaces(line:String):Int = {
    val CodeRegex(whitespaces) = line
    whitespaces.foldLeft(0) {
      case (acc, ' ')  => acc + 1
      case (acc, '\t') => acc + 2
    }
  }
  private def trimIndentation(code:List[String]):List[String] = {
    val min = (code map spaces).min
    code.map(_.substring(min))
  }
}