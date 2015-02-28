(function (document, window) {
  'use strict';

  // wait for impress.js to be initialized
  document.addEventListener("impress:init", function (event) {
    // Getting API from event data.
    // So you don't event need to know what is the id of the root element
    // or anything. `impress:init` event data gives you everything you
    // need to control the presentation that was just initialized.
    var api = event.detail.api;

    // KEYBOARD NAVIGATION HANDLERS

    // Prevent default keydown action when one of supported key is pressed.
    document.addEventListener("keydown", function (event) {
      if ( event.keyCode >= 33 && event.keyCode <= 34 ) {
        event.preventDefault();
      }
    }, false);

    // Trigger impress action (next or prev) on keyup.

    // Supported keys are:
    // [space] - quite common in presentation software to move forward
    // [up] [right] / [down] [left] - again common and natural addition,
    // [pgdown] / [pgup] - often triggered by remote controllers,
    // [tab] - this one is quite controversial, but the reason it ended up on
    //   this list is quite an interesting story... Remember that strange part
    //   in the impress.js code where window is scrolled to 0,0 on every presentation
    //   step, because sometimes browser scrolls viewport because of the focused element?
    //   Well, the [tab] key by default navigates around focusable elements, so clicking
    //   it very often caused scrolling to focused element and breaking impress.js
    //   positioning. I didn't want to just prevent this default action, so I used [tab]
    //   as another way to moving to next step... And yes, I know that for the sake of
    //   consistency I should add [shift+tab] as opposite action...
    document.addEventListener("keyup", function (event) {
      if ( event.keyCode >= 33 && event.keyCode <= 34 ) {
        switch (event.keyCode) {
          case 33: // pg up
          case 37: // left
          case 38: // up
            var id = api.prev().id;
            PresenterApi.goto(id);
            break;
          case 9:  // tab
          case 32: // space
          case 34: // pg down
          case 39: // right
          case 40: // down
            var id = api.next().id;
            PresenterApi.goto(id);
            break;
        }

        event.preventDefault();
      }
    }, false);

    // delegated handler for clicking on the links to presentation steps
    document.addEventListener("click", function (event) {
      // event delegation with "bubbling"
      // check if event target (or any of its parents is a link)
      var target = event.target;
      while ((target.tagName !== "A") &&
        (target !== document.documentElement)) {
        target = target.parentNode;
      }

      if (target.tagName === "A") {
        var href = target.getAttribute("href");

        // if it's a link to presentation step, target this step
        if (href && href[0] === '#') {
          target = document.getElementById(href.slice(1));
        }
      }

      if (api.goto(target)) {
        event.stopImmediatePropagation();
        event.preventDefault();
      }
    }, false);

    // touch handler to detect taps on the left and right side of the screen
    // based on awesome work of @hakimel: https://github.com/hakimel/reveal.js
    document.addEventListener("touchstart", function (event) {
      if (event.touches.length === 1) {
        var x = event.touches[0].clientX,
          width = window.innerWidth * 0.1,
          result = null;

        if (x < width) {
          result = api.prev();
        } else if (x > window.innerWidth - width) {
          result = api.next();
        }

        if (result) {
          event.preventDefault();
        }
      }
    }, false);

  }, false);
})(document, window);
