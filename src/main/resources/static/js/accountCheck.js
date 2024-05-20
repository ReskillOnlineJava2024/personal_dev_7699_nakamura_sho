function validate() {
    var password = document.getElementById("password").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var passwordPattern = /^(?=.*\d)(?=.*[a-z]).{8,16}$/;
    
    
    if (name === "" || email === "" || password === "") {
        alert("未入力の項目があります");
        return false;
    }
    
    if(!passwordPattern.test(password)) {
		 alert("英数字8～16文字以内のパスワードを設定してください");
		 return false;
	}
	
	return true;
}