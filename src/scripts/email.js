import { rendered } from "./render.js";
import { sendEmail } from "./requests.js";

export function sendJobRelatoryToEmail () {
  const sendButton = document.getElementById("send-email");
  
  sendButton.addEventListener("click", async event => {
    event.preventDefault();

    const inputEmail = document.getElementById("email-value");

    const email = inputEmail.value;

    if (email && rendered) {
      const status = await sendEmail(email);
  
      if (status.sucess) {
        console.log("enviou");
      } else {
        console.log(":(");
      }
    }
  })
}