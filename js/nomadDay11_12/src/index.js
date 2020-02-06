/*
1. Have a reset (C) button.
2. Support all basic operations (+ , - , * , / )
3. Support for 'equals' ( = ) button.
4. Allow value carrying. ex)2 * 2 * 2 * 2 * 2  without pressing equals.
*/

const h1 = document.querySelector("h1");
let result = "";
let oper = "";
let text = "";

function input(input) {

  if (isNaN(input)) {
    h1.innerHTML = "";
    text += input;
  } else if (!isNaN(input) && oper === "") {
    h1.innerHTML += `${input}`;
    text += input;
  }
}

function calc() {
  result = eval(text);
  console.log(text);
  text = result;
  h1.innerHTML = `${text}`;
  console.log(text);
  oper = "";
}

function init() { 
  h1.innerHTML = "";
  text="";
}


