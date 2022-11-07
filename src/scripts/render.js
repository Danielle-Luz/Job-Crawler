import { getJobs } from "./requests.js";

export let rendered = false;

export function renderCards (foundJobs) {
  const cardContainer = document.querySelector(".card-container");

  cardContainer.innerHTML = "";

  if (foundJobs.length == 0) {
    const emptyMessage = "<h2 class='empty-message title title-size-2'>Insira uma nova url para ver alguma vaga</h2>"

    cardContainer.innerHTML = emptyMessage;
  } else {
    rendered = true;

    foundJobs.forEach( job => {
      const jobHtml = `
      <article class="card card-content d-flex flex-column full-width">
          <header>
            <h2 class="title title-size-2">${job.jobName}</h2>
            <ul class="card-content d-flex">
              <li class="text-size-2">${job.company}</li>
              <li class="text-size-2">${job.typeOfWork}</li>
            </ul>
          </header>
          <main>
            <p class="text text-size-1">
              ${job.description}
            </p>
          </main>
          <footer class="card-content d-flex flex-column justify-between">
            <ul class="align-center card-content d-flex">
              ${job.salary != 0 ? '<li class="card-label fit-height text-size-2 text-center"> R$ ' + job.salary.toFixed(0) + '</li>' : ""}
              <li class="card-label fit-height text-size-2 text-center">São Paulo</li>
            </ul>
            <a class="button-brand text-center" href="${job.link}">Acessar a vaga</a>
          </footer>
        </article>
      `;

      cardContainer.insertAdjacentHTML("beforeend", jobHtml);
    });
  }
}

export function renderFoundJobs () {
  const searchButton = document.getElementById("search");
  
  searchButton.addEventListener("click", async event => {
    event.preventDefault();

    const inputUrl = document.getElementById("url-value");

    const url = inputUrl.value;

    const domain = url.split(".")[1];

    if (domain == "trabalhabrasil") {
      
      const response = await getJobs(url);

      if (response.ok) {
        const foundJobs = await response.json();
  
        renderCards(foundJobs);
      }
    }
  })
}