const writeForm = document.querySelector(".writeForm");
const inputFile = writeForm.querySelector(".input__file");
const posterImg = writeForm.querySelector(".posterImg");
const inputTitle = writeForm.querySelector(".input__title");
const inputRating = writeForm.querySelector(".input__rating");


// rating
function handleRange(e) {
	const span = writeForm.querySelector(".raitng__span");
	span.innerHTML = `${e.target.value}점`;
}

//포스터 업로드
function handleInputFile(e) {
	const reader = new FileReader();
    const file = event.target.files[0];
    reader.onloadend = () => {
    	posterImg.src = reader.result;
    }
    reader.readAsDataURL(file);
}

function init() {
	console.log("review.js")
	inputRating.addEventListener("change", handleRange);
	inputFile.addEventListener("change", handleInputFile);
}

init();