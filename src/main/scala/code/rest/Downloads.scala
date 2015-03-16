package code.rest

import java.io.ByteArrayInputStream

import net.liftweb._
import http._
import rest.RestHelper
import util.TimeHelpers._

object Downloads extends RestHelper {
  lazy val slides = LiftRules.loadResource("/slides.pdf")
  lazy val headers = slides.map { bytes =>
    ("Content-type" -> "application/octet-stream") ::
    ("Content-length" -> bytes.length.toString) ::
    ("Content-disposition" -> "attachment; filename=type-prog-scala.pdf") ::
    Nil
  }

  serve {
    case "download" :: Nil Get _ => {
      val response = slides.zip(headers).map { case (bytes, heads) =>
        val s = new ByteArrayInputStream(bytes)
        new StreamingResponse(s, () => s.close(), s.available(), heads, Nil, 200)
      }.headOption.getOrElse(new ServiceUnavailableResponse(10.minutes))

      response
    }
  }
}
