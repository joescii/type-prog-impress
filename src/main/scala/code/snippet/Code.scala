package code.snippet

import net.liftweb.http.{LiftRules, S}
import net.liftweb.util.Helpers._
import net.liftweb.common.Full

import scala.util.Try
import scala.xml.NodeSeq

object Code {
  private val newline = System.getProperty("line.separator")

  private def src = (for {
    name <- S.attr("src")
    code <- LiftRules.loadResourceAsString(name)
  } yield {
    val lines = code.split("(?s)\r?\n").toList
    val rs = ranges
    val selectedLines = if(rs.isEmpty) lines else
      rs.map(r => lines
        .drop(r.head - 1)
        .take(r.last - r.head + 1)
      ).reduce(_ ++ _)
    val trimmed = trimIndentation(selectedLines)
    trimmed.mkString(newline)
  }).openOr("// Source not found!!!")

  private def lang = S.attr("src").map(_.split("\\.").last match {
    case "js" => "javascript"
    case other => other
  }).openOr("")

  private def ranges:List[Range] = Stream.from(1).map( i => for {
    lines <- S.attr(if(i == 1) "l" else "l"+i)
    arr = lines.split("-")
    first <- Try(arr.head.toInt).toOption
    last  <- Try(arr.last.toInt).toOption
  } yield {
    first to last
  }).takeWhile(_.isDefined)
    .collect { case Full(r) => r }
    .toList

  private def append(html:NodeSeq) = "* *+" #> html

  def render(in:NodeSeq):NodeSeq = {
    val bg = in.headOption
      .map(_ \ "@data-bg")
      .map(_.toString)
      .map(bg => if(bg contains "sc") "light" else "dark")
      .headOption.getOrElse("light")

    val html = <pre>
      <code class={s"$lang $bg"}>
        <div>{src}</div>
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