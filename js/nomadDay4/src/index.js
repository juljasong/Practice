// <⚠️ DONT DELETE THIS ⚠️>
//import "./styles.css";
// <⚠️ /DONT DELETE THIS ⚠️>

const body = document.body;
let width = window.innerWidth;

function handleResize(event) {
  if(width > 500) {
    body.style.backgroundColor = "orange";
  } else {
    body.style.backgroundColor = "blue";
  }
} 

window.addEventListener("resize", handleResize);

