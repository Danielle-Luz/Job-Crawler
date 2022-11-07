import { renderCards } from "./render.js";

export function sliderEffects () {
  for (let e of document.querySelectorAll('input[type="range"].slider-progress')) {
    e.style.setProperty('--value', e.value);
    e.style.setProperty('--min', e.min == '' ? '0' : e.min);
    e.style.setProperty('--max', e.max == '' ? '100' : e.max);
    e.addEventListener('input', () => e.style.setProperty('--value', e.value));
  }
}

function changeValueWhenSlide () {
  const inputRange = document.getElementById("salary-range");

  const salaryValue = document.getElementById("salary-value");

  salaryValue.innerText = "R$ " + inputRange.value;
}

function getJobsBySalary (salary) {
  const foundJobs = JSON.parse(localStorage.getItem("foundJobs"));

  if (foundJobs != null) {
    const filteredJobs = foundJobs.filter( job => {
      return job.salary >= parseFloat(salary);
    });

    renderCards(filteredJobs);
  }
}

export function addEventToSlide () {
  const inputRange = document.getElementById("salary-range");

  inputRange.addEventListener("input", () => {
    getJobsBySalary(inputRange.value);

    changeValueWhenSlide();
  });
}