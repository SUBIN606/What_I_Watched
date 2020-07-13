const searchWrap = document.querySelector(".searchWrap");
const searchBtn = searchWrap.querySelector(".searchBtn");
const inputSearch = searchWrap.querySelector(".input__search");
const contentsContainer = searchWrap.querySelector(".contents__container");
const contentsList = contentsContainer.querySelector(".contents__list");
const viewMoreBtn = contentsContainer.querySelector(".viewMoreBtn");

const writeArea = document.querySelector(".writeFormWrap");

// api에서 받아올 데이터값을 담을 변수
let movieList = [];

// viewmore를 위한 페이징 값 10개씩 가져옴
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
	movieList= [];
	
	// 리뷰 작성 form 숨기기
	writeArea.classList.add("hide");
	
	// 만약 다시검색했을 경우 화면에 출력되어있는 li태그들 모두 삭제
	if(contentsList.hasChildNodes()){
		deleteContents();
	}
	
	const keyword = inputSearch.value.trim();
	if(keyword === "") {
		searchAlert("검색어를 입력하세요!");
	}else if(keyword.length < 2) {
		searchAlert("검색어는 두 글자 이상 입력해주세요!");
	}else{
		removeAlert();
		searchContent(keyword, false, 0);
	}
	
}

// 검색관련 알림 출력
function searchAlert(msg) {
	removeAlert();
	const alert = document.createElement("p");
	alert.classList.add("alert");
	alert.innerHTML = msg;
	searchWrap.appendChild(alert);
}

// 알림 삭제
function removeAlert(){
	if(searchWrap.querySelector(".alert")){
		const oldAlert = searchWrap.querySelector(".alert");
		searchWrap.removeChild(oldAlert);
	}
}

// 검색 값 더 불러오기
function clickMoreBtn() {
	
	const keyword = inputSearch.value;
	
	// 이전에 불러온 개수 이후 부터 불러오기 위해
	const nextStart = getDisplay() + 1;

	searchContent(keyword, true, nextStart);
	
	// 불러올 시작점 갱신
	setDisplay();

}


// 영화 검색 API
function searchContent(keyword, viewMore, nextStart) {
	
	// API호출하는 컨트롤러와 통신
	fetch(`/reviews/search?keyword=${keyword}&viewMore=${viewMore}&nextStart=${nextStart}`,{
		method: 'get',
		headers: {'Content-Type': 'text/json;charset=utf-8'}
	})
	.then(response => response.json())
	.then(data => {		
		
		const nextStart = getDisplay() + 1;
		
		// 더 불러올 내역이 없으면 view more버튼 숨기기
		if(data.total >= nextStart){
			viewMoreBtn.classList.remove("hide");
		}else{
			viewMoreBtn.classList.add("hide");
		}
		
		if(movieList.length === 0){ // 처음 혹은 다시 검색하는 경우
			movieList = data.items;
			paintContents(movieList);
		}else{	// view more
			const newLoades = data.items;
			paintContents(newLoades);
			movieList = movieList.concat(newLoades);
		}

	})
}

// 검색결과 화면 출력
function paintContents(data) {
	
	contentsContainer.classList.remove("hide");
	
	// 검색 결과가 없을 경우
	if(data.length === 0){
		const p = document.createElement("p");
		p.innerHTML = "검색결과가 없습니다😓";
		contentsList.appendChild(p);
	}
	
	data.forEach((content, index) => {
		const li = document.createElement("li");
		li.id = getDisplay()===10?index:index+(getDisplay()-10);
		
		const titleWrap = document.createElement("div");	
		const titleSpan = document.createElement("span");	
		titleSpan.classList.add("title");
		const subTitleSpan = document.createElement("span");
		subTitleSpan.classList.add("subtitle");
		
		const chooseBtn = document.createElement("button");
		chooseBtn.classList.add("btn");
		chooseBtn.innerHTML = "선택";
		chooseBtn.addEventListener("click", clickChooseBtn);
		
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
function clickChooseBtn(e) {
	e.preventDefault();
	console.log(e.target.parentNode.tagName);
	// 리뷰 작성 form 보이게
	writeArea.classList.remove("hide");
	
	const img = document.querySelector(".posterImg");
	const inputTitle = document.querySelector(".input__title");
	const inputSubTitle = document.querySelector(".input__subtitle");
	const inputPosterImg = document.querySelector(".input__posterImg");
	
	if(e.target.parentNode.tagName === "LI"){
		const li = e.target.parentNode;
		const title = li.querySelector(".title").innerHTML;
		
		// 선택한 컨텐츠 객체를 movieList배열에서 찾기
//		const content = movieList.find(movie => {
//			return movie.title===title;
//		})
		const content = movieList[li.id];
		console.log("클릭한 컨텐츠 : ", content);
		img.src = content.image;
		inputTitle.value = convertFureString(content.title);
		inputSubTitle.value = content.subtitle;
		inputPosterImg.value = content.image;
	}
	
	inputSearch.value = "";
	movieList = [];
	contentsContainer.classList.add("hide");
}

// title에서 <b></b>태그 제거
function convertFureString(text) {
	let convert = "";
	
	while(text.includes("<b>") || text.includes("</b>")){
		convert = text.replace("<b>", "");
		console.log(convert);
		convert = convert.replace("</b>", "");
		console.log(convert);
		text = convert;
	}

	return convert;
}

function init() {
	console.log("searchContents.js")
	searchBtn.addEventListener("click", clickSearchBtn);
	viewMoreBtn.addEventListener("click", clickMoreBtn);
}

init();