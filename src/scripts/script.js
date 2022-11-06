function fetchData(){
    fetch("https://reqres.in/api/users")
    .then(response => {
        if (!response.ok) {
            throw Error("Error");
        }
        return response.json();
    })
    .then(data => {
        const html = data.data
        .map(user => {
            return `
            <li class="cards_item">
            <p><img src="${user.avatar}" class="d-block w-100" alt="${user.first_name}" /><p>
            <p>Name: ${user.first_name}</p>
            <p>Email: ${user.email}</p>
            </li>
            `;
        })
        .join('');
        document.querySelector("#").insertAdjacentHTML("afterbegin", html);
    })
    .catch(error => {
        console.log(error);
    });
}

fetchData();