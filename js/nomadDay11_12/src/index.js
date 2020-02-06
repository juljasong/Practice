/*
1. Have a reset (C) button.
2. Support all basic operations (+ , - , * , / )
3. Support for 'equals' ( = ) button.
4. Allow value carrying. ex)2 * 2 * 2 * 2 * 2  without pressing equals.
*/

const h1 = document.querySelector("h1");
let num1 = "";
let num2 = "";
let oper = "";
let oper2 = "";
let result = "";

function input(input) {
  if(isNaN(input) && num1 !== "" && num2 !== "") {
    oper2 = input;
    num1 = calc();
    oper = oper2;
    h1.innerHTML=""; 
    console.log('1. oper1 : ' + oper + ' oper2 : ' + oper);
  }else if(isNaN(input)) {
    oper = input;
    h1.innerHTML=""; 
    console.log('2. oper1 : ' + oper + ' oper2 : ' + oper);
  } else if(!isNaN(input) && oper !== "") {
    h1.innerHTML += `${input}`;
    num1 = h1.innerHTML;
    console.log('num1 : ' + num1);
  } else if (!isNaN(input) && oper === "" ) {
    h1.innerHTML += `${input}`;
    num2 = h1.innerHTML;
    console.log('num2 : ' + num2);
  } 
}

function calc() {
  result = eval(num1 + oper + num2);
  h1.innerHTML = `${result}`;
  console.log(result);
  num1 = result;
  return num1;
}

function init() { 
  h1.innerHTML = "";
  num1 = "";
  num2 = "";
  oper = "";
  result = "";
}


