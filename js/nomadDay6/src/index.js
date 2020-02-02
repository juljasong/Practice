const select = document.querySelector("select");

function init() {
    loadCountry();
}

function loadCountry() {
    const currentCountry = localStorage.getItem("country");
    if(currentCountry === null) {
        askForCountry();
    } else {
        select.value = currentCountry;
        askForCountry();
    }
}

function askForCountry() {
    select.addEventListener("change", handleSelect);
}

function handleSelect(event) {
    const country = event.target.value;
    console.log(country);
    saveCountry(country);
}
function saveCountry(country) {
    localStorage.setItem("country", country);
}

init();


