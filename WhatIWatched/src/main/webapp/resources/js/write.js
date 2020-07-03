const client_id = 'QfR_teL8wzzDbCeWabjG';
const client_secret = 'ByMZaZGfmS';

const writeForm = document.querySelector(".writeForm");
const inputContentTitle = writeForm.querySelector(".input__contentTitle");
const searchBtn = writeForm.querySelector(".searchBtn");
const inputFile = writeForm.querySelector(".input__file");

const contentsContainer = writeForm.querySelector(".contents__container");
const contentsList = contentsContainer.querySelector(".contents__list");
const viewMoreBtn = contentsContainer.querySelector(".contents__more__btn");

let movieList = [];

let display = 10;
function setDisplay(){
	display += 10;
}
function getDisplay(){
	return display;
}

// 영화 검색
function clickSearchBtn() {
	if(contentsList.hasChildNodes()){
		let firstChild = contentsList.firstChild;
		while(firstChild){
			contentsList.removeChild(firstChild);
			firstChild = contentsList.firstChild;
		}
	}
	const keyword = inputContentTitle.value;
	searchContent(keyword, false, 10);
}

// 검색 값 더 불러오기
function clickMoreBtn() {
	// display 값 증가
	setDisplay();
	const keyword = inputContentTitle.value;
	searchContent(keyword, true, getDisplay());
}


// 영화 검색 API
function searchContent(keyword, viewMore, display) {
	
	fetch(`/reviews/search?keyword=${keyword}&viewMore=${viewMore}&display=${display}`,{
		method: 'get',
		headers: {'Content-Type': 'text/json;charset=utf-8'}
	})
	.then(response => response.json())
	.then(data => {
		if(movieList.length > 0){
			let newLoades = data.items.slice(movieList.length);
			paintContents(newLoades);
			movieList = movieList.concat(newLoades);
		}else{
			movieList = data.items;
			paintContents(movieList);
		}
	})
}

// 검색결과 화면 출력
function paintContents(data) {
	
	contentsContainer.classList.remove("hide");
	
	data.forEach((content, index) => {
		const li = document.createElement("li");
		li.addEventListener("click", clickContent);
		
		const titleWrap = document.createElement("div");	
		const titleSpan = document.createElement("span");	
		titleSpan.classList.add("title");
		const subTitleSpan = document.createElement("span");
		subTitleSpan.classList.add("subtitle");
		
		const posterImg = new Image();
		
		titleSpan.innerHTML = content.title;
		subTitleSpan.innerHTML = `(${content.subtitle})`;
		
		posterImg.src = content.image!==""?content.image:'../resources/image/sad.png';
		posterImg.alt = '이미지 없음';
		
		li.appendChild(posterImg);
		titleWrap.appendChild(titleSpan);
		content.subtitle!==""?titleWrap.appendChild(subTitleSpan):null;
		li.appendChild(titleWrap);
		
		contentsList.appendChild(li);	
	})
	
}

// 컨텐츠 선택
function clickContent(e) {

	if(e.target.parentNode.tagName === "DIV"){
		const div = e.target.parentNode;
		const title = div.querySelector("span").innerHTML;
		
		const content = movieList.find(movie => {
			return movie.title === title;
		})

		inputContentTitle.value = convertFureString(content.title);
	}
}

// <b></b>태그 제거
function convertFureString(text) {
	let convert = text.replace("<b>", "");
	console.log(convert);
	convert = convert.replace("</b>", "");
	console.log(convert);
	return convert;
}

// 포스터 업로드
function handleInputFile(e) {
	const imgPreview = document.querySelector(".writeForm__img__preview");
	const reader = new FileReader();
    const file = event.target.files[0];
    reader.onloadend = () => {
    	imgPreview.src = reader.result;
    }
    reader.readAsDataURL(file);
}

function init() {
	console.log("write.js")
	searchBtn.addEventListener("click", clickSearchBtn);
	inputFile.addEventListener("change", handleInputFile);
	viewMoreBtn.addEventListener("click", clickMoreBtn);
}

init();