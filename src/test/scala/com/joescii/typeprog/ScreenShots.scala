package com.joescii.typeprog

import org.scalatest.FlatSpec
import org.scalatest.selenium.Chrome
import org.openqa.selenium.{ Keys, By }
import org.openqa.selenium.interactions.Actions

class ScreenShots extends FlatSpec with Chrome {
  "The presentation" should "advance until the end" in {
    go to ("http://localhost:8080/")
    webDriver.manage().window().maximize()
    setCaptureDir("target/screenshots")

    def pgDown = new Actions(webDriver).sendKeys(Keys.PAGE_DOWN)

    Stream.continually(currentUrl).takeWhile(!_.endsWith("/#/links")).zipWithIndex.foreach { case (url, i) =>
      Thread sleep 1500
      if(currentUrl endsWith "/#/cat-memes") Thread sleep 4000 // let the cat memes appear
      capture to (i.toString)
      pgDown.perform()
    }


  }

  "The suite" should "quit" in { quit() }
}
