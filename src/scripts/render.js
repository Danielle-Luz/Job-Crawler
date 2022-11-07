export function renderCards (array) {
  const cardContainer = document.querySelector(".card-container");

  if (array.length == 0) {
    const emptyMessage = "<h2 class='title title-size-2'>Insira uma nova url para ver alguma vaga</h2>"

    cardContainer.innerHTML = emptyMessage;
  }
}