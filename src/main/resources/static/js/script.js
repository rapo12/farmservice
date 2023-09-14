console.log("heyyyyys");
const footerContent = document.getElementById("footerContent");
let p = document.createElement('p');
p.classList.add("text-white")
const year = new Date();
p.innerHTML = `MGFARM project &copy ${year.getFullYear()}`;
footerContent.appendChild(p);
