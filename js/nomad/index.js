/* DOM : Document Object Model */

const title = document.querySelector('#title');
title.innerHTML = '집에 가고 싶어요';

function handleClickRed() {
  title.style.color = 'red';
}

function handleClickBlue() {
  title.style.color = '#34495e';
}

//title.addEventListener('click', handleClick);
//console.log(title);


if(title.style.color === 'red') {
  title.addEventListener('click', handleClickBlue);
} else {
  title.addEventListener('click', handleClickRed);
}