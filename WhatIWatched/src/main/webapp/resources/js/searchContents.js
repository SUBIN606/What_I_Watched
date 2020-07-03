const client_id = 'QfR_teL8wzzDbCeWabjG';
const client_secret = 'ByMZaZGfmS';

const writeForm = document.querySelector(".writeForm");
const inputContentTitle = writeForm.querySelector(".input__search");
const searchBtn = writeForm.querySelector(".searchBtn");
const inputFile = writeForm.querySelector(".input__file");

const contentsContainer = writeForm.querySelector(".contents__container");
const contentsList = contentsContainer.querySelector(".contents__list");
const viewMoreBtn = contentsContainer.querySelector(".contents__more__btn");

// api에서 받아올 데이터값을 담을 변수
let movieList = [];

// viewmore를 위한 페이징 값
let display = 10;
function setDisplay(){
	display += 10;
}
function getDisplay(){
	return display;
}

// 영화 검색 버튼
function clickSearchBtn() {
	
	// 다시 검색하는 경우를 위해 빈 배열로 초기화
	movieList = [];
	
	// 만약 다시검색했을 경우 화면에 출력되어있는 li태그들 모두 삭제
	if(contentsList.hasChildNodes()){
		deleteContents();
	}
	const keyword = inputContentTitle.value;
	searchContent(keyword, false, 0);
}

// 검색 값 더 불러오기
function clickMoreBtn() {
	console.log(display);
	const keyword = inputContentTitle.value;
	const nextStart = getDisplay() + 1;
	console.log(nextStart);
	searchContent(keyword, true, nextStart);
	setDisplay();
	console.log(display);
}


// 영화 검색 API
function searchContent(keyword, viewMore, nextStart) {
	
	fetch(`/reviews/search?keyword=${keyword}&viewMore=${viewMore}&nextStart=${nextStart}`,{
		method: 'get',
		headers: {'Content-Type': 'text/json;charset=utf-8'}
	})
	.then(response => response.json())
	.then(data => {
		const nextStart = getDisplay() + 1;
		console.log("total : ", data.total , " / nextStart : " , nextStart);
		if(data.total >= nextStart){
			viewMoreBtn.classList.remove("hide");
		}else{
			viewMoreBtn.classList.add("hide");
		}
		if(movieList.length > 0){
			let newLoades = data.items;
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
		
		const titleWrap = document.createElement("div");	
		const titleSpan = document.createElement("span");	
		titleSpan.classList.add("title");
		const subTitleSpan = document.createElement("span");
		subTitleSpan.classList.add("subtitle");
		
		const chooseBtn = document.createElement("button");
		chooseBtn.innerHTML = "선택";
		chooseBtn.addEventListener("click", clickContent);
		
		const posterImg = new Image();
		
		titleSpan.innerHTML = content.title;
		subTitleSpan.innerHTML = `(${content.subtitle})`;
		
		posterImg.src = content.image!==""?content.image:'../resources/image/sad.png';
		posterImg.alt = '이미지 없음';
		
		li.appendChild(posterImg);
		
		titleWrap.appendChild(titleSpan);
		content.subtitle!==""?titleWrap.appendChild(subTitleSpan):null;
		
		li.appendChild(titleWrap);
		li.appendChild(chooseBtn);
		
		contentsList.appendChild(li);	
	})
	
}

//li태그값 삭제
function deleteContents(){
	let firstChild = contentsList.firstChild;
	while(firstChild){
		contentsList.removeChild(firstChild);
		firstChild = contentsList.firstChild;
	}
}

// 컨텐츠 선택
function clickContent(e) {
	e.preventDefault();
	if(e.target.parentNode.tagName === "LI"){
		const li = e.target.parentNode.parentNode;
		const title = li.querySelector("span").innerHTML;
		
		// 선택한 컨텐츠 객체를 movieList배열에서 찾기
		const content = movieList.find(movie => {
			return movie.title === title;
		})

		convertFureString(content.title);
	}
}

// title에서 <b></b>태그 제거
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