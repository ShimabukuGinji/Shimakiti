'use strict';
function main () {
  const input1 = document.querySelector('#input1')
  const input2 = document.querySelector('#input2')
  const input3 = document.querySelector('#input3')
  const input4 = document.querySelector('#input4')
  const input5 = document.querySelector('#input5')
  const figureImage1 = document.querySelector('#figureImage1')
  const figureImage2 = document.querySelector('#figureImage2')
  const figureImage3 = document.querySelector('#figureImage3')
  const figureImage4 = document.querySelector('#figureImage4')
  const figureImage5 = document.querySelector('#figureImage5')

  input1.addEventListener('change', (event) => {
    const [file] = event.target.files

    if (file) {
      figureImage1.setAttribute('src', URL.createObjectURL(file))
    }
  })

  input2.addEventListener('change', (event) => {
    const [file] = event.target.files

    if (file) {
      figureImage2.setAttribute('src', URL.createObjectURL(file))
    }
  })

  input3.addEventListener('change', (event) => {
    const [file] = event.target.files

    if (file) {
      figureImage3.setAttribute('src', URL.createObjectURL(file))
    }
  })

  input4.addEventListener('change', (event) => {
    const [file] = event.target.files

    if (file) {
      figureImage4.setAttribute('src', URL.createObjectURL(file))
    }
  })

  input5.addEventListener('change', (event) => {
    const [file] = event.target.files

    if (file) {
      figureImage5.setAttribute('src', URL.createObjectURL(file))
    }
  })
}
main()