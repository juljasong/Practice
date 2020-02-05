const form = document.querySelector("form")
const numberForm = form.querySelector("input");
const h2 = document.querySelector("h2");
const select = document.querySelector(".select");
const result = document.querySelector("b");

let selectedRange = 10;
let selectedNumber = null;
let randomNumber = null;

function init() {
  addEventListener("submit", handleSubmit);
}

function handleChange(range) {
  selectedRange = range;
  h2.innerHTML = `Generate a number between 0 and ${selectedRange}`;
  random();
  console.log("범위 : ~" + selectedRange);
}

function handleSubmit(event) {
  event.preventDefault();
  selectedNumber = parseInt(numberForm.value);
  if (isNaN(selectedNumber)) {
    result.innerHTML = `Choose number!`;
    select.classList.remove("showing");
    select.classList.add("hidden");
  } else if (selectedNumber > selectedRange || selectedNumber < 0) {
    result.innerHTML = `Choose number between selected range!`;
    select.classList.remove("showing");
    select.classList.add("hidden");
  } else {
    random();
    select.innerHTML = `You chose: ${selectedNumber}, the machine chose: ${randomNumber}`;
    select.classList.add("showing");
    play();
  }
  console.log("선택된 숫자 : " + selectedNumber);
}

function random() {
  randomNumber = Math.ceil(Math.random()*selectedRange);
  console.log("랜덤 숫자 : " + randomNumber);
}

function play() {
  if (selectedNumber > randomNumber) {
    result.innerText = `You Win!`;
  } else if (selectedNumber < randomNumber){
    result.innerText = `You lost!`;
  } else {
    result.innerText = `Oh...! You're my destiny...`;
  }
}

init();
