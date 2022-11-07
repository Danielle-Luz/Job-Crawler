import { sendJobRelatoryToEmail } from "./email.js";
import { renderCards, renderFoundJobs } from "./render.js";
import { addEventToSlide, sliderEffects } from "./slider.js";

renderCards([]);

renderFoundJobs();

sendJobRelatoryToEmail();

sliderEffects();

addEventToSlide();