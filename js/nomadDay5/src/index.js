import "./styles.css";

// You're gonna need this
const NINE_HOURS_MILLISECONDS = 32400000;
const h3 = document.querySelector("h3");

function getTime() {
  // Don't delete this.
  const xmasDay = new Date("2020-12-24:00:00:00+0900");
  const today = Date.parse(new Date().toUTCString() + NINE_HOURS_MILLISECONDS);

  const remainTime = xmasDay - today;
  const days = Math.floor(remainTime / 86400000); // 1000*60*60*24
  const hours = Math.floor((remainTime % 86400000) / 3600000);
  const mins = Math.floor((remainTime % 3600000) / 60000);
  const secs = Math.floor(remainTime % 60000) / 1000;
  h3.innerHTML = `${days}d 
    ${hours < 10 ? `0${hours}h` : `${hours}h`} 
    ${mins < 10 ? `0${mins}m` : `${mins}m`}
    ${secs}s`;
}

function init() {
  getTime();
  setInterval(getTime, 1000);
}

init();
