const section = document.querySelector('section');
	var pagenum = document.getElementById("num").innerHTML;
console.log(pagenum);

	let requestURL = 'https://reqres.in/api/users?page='+pagenum;
	let request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();

	request.onload = function() {
	const users = request.response;
	showUsers(users);
}

	function showUsers(obj) {
		const users = obj['data'];

	for (let i = 0; i < users.length; i++) {
		const myArticle = document.createElement('article');
		const  = document.createElement('p');
		const myPara1 = document.createElement('p');
		const myPara2 = document.createElement('p');
		const myimg = document.createElement('img');

		myH2.textContent = users[i].email;	
		myPara1.textContent = users[i].first_name;
		myPara2.textContent = users[i].last_name;
		myimg.src = users[i].avatar;

		myArticle.className += "card-container";
		myArticle.appendChild(myH2);
		myArticle.appendChild(myPara1);
		myArticle.appendChild(myPara2);
		myArticle.appendChild(myimg);
		section.appendChild(myArticle);
		}
	}	