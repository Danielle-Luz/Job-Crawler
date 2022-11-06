function fetchData(){
    let dataUrl = {
        url: "https://www.trabalhabrasil.com.br/vagas-empregos/programador"
    }
    fetch("https://job-crawler.herokuapp.com/trabalhos",{
        method: "POST",
        headers: {
            "Content-type":"application/json"
        },
        body: JSON.stringify(dataUrl)
    })
    .then(response => {
        if (!response.ok) {
            throw Error("Error");
        }
        return response.json();
    })
    .then(data => {
        const html = data
        .map(job => {
            return `
            <li class="cards_item">
            <div class="card">
              <div class="card_content">
                <h2 class="card_title">${job.jobName}</h2>
                <p class="card_text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus, voluptate maxime nihil ipsa deserunt tempora aliquam nam similique corrupti optio sed, porro deleniti autem aut! Recusandae iusto sit neque veniam.</p>
                <a href="${job.link}" target="_blank"><button class="btn card_btn">Ver Vaga</button></a>
              </div>
            </div>
            </li>
            `;
        })
        .join('');
        document.querySelector("#Vagas").insertAdjacentHTML("afterbegin", html);
    })
    .catch(error => {
        console.log(error);
    });
}

fetchData();