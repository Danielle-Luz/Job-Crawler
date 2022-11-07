import { sendEmail } from "./requests.js";

export function sendJobRelatoryToEmail () {
  const sendButton = document.getElementById("send-email");
  
  sendButton.addEventListener("click", async () => {
    const inputEmail = document.getElementById("email-value");

    const email = inputEmail.value;

    const status = await sendEmail(email);

    if (status.sucess) {
      console.log("enviou");
    } else {
      console.log(":(");
    }
  })
}