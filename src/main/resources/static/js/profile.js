'use strict';

function main () {
  const input1 = document.querySelector('#input1')
  const figureImage1 = document.querySelector('#figureImage1')

  input1.addEventListener('change', (event) => {
    const [file] = event.target.files

    if (file) {
      figureImage1.setAttribute('src', URL.createObjectURL(file))
    }
  })
}
main()