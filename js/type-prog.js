/**
 * Created by jbarnes on 3/23/2014.
 */

(function ( document, window, $ ) {
  'use strict';

  document.addEventListener("keyup", function ( event ) {
    if ( event.keyCode === 65 ) {
      $('.all').toggleClass('active');
      event.preventDefault();
    }
  }, false);


})(document, window, jQuery);