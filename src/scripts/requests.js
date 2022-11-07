export async function getJobs (url) {
  const urlJson = JSON.stringify({url: url});

  const request = await fetch("https://job-crawler.herokuapp.com/trabalhos", {
    method: "POST",
    headers: {
      "Content-type": "application/json"
    },
    body: urlJson
  })

  const response = await request.json();

  return response;
}

export async function sendEmail (email) {
  const emailJson = JSON.stringify({email: email});

  const request = await fetch("https://job-crawler.herokuapp.com/email", {
    method: "POST",
    headers: {
      "Content-type": "application/json"
    },
    body: emailJson
  })

  const response = await request.json();

  return response;
}