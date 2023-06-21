/* global bootstrap: false */
(() => {
  const text = document.querySelector('.text');
  const colors = ['red', 'blue', 'green', 'orange'];
  let colorIndex = 0;

  setInterval(changeColor, 1000);


  function changeColor() {
    text.style.color = colors[colorIndex];
    colorIndex = (colorIndex + 1) % colors.length;
  }
  'use strict'
  const tooltipTriggerList = Array.from(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(tooltipTriggerEl => {
    new bootstrap.Tooltip(tooltipTriggerEl)
  })
})()

window.addEventListener('DOMContentLoaded', function() {
  var table = document.getElementById('elmaTable');
  var rows = Array.from(table.getElementsByTagName('tr')).slice(1);

  rows.sort(function(a, b) {
    var dateA = new Date(a.cells[1].textContent);
    var dateB = new Date(b.cells[1].textContent);
    return dateA - dateB;
  });

  for (var i = 0; i < rows.length; i++) {
    table.appendChild(rows[i]);
  }
});


/*
document.addEventListener('DOMContentLoaded', function() {
  var animatedText = document.querySelector('.animated-text');

  animatedText.addEventListener('mouseover', function() {
    animatedText.style.animationPlayState = 'paused';
  });

  animatedText.addEventListener('mouseout', function() {
    animatedText.style.animationPlayState = 'running';
  });
});

*/