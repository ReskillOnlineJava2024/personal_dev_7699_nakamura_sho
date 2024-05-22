function updateValidate() {
    var password = document.getElementById("password").value;
    var passwordConfirm = document.getElementById("passwordConfirm").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var passwordPattern = /^(?=.*\d)(?=.*[a-z]).{8,16}$/;
    
    
    if (name === "" || email === "" || password === "" || passwordConfirm === "") {
        alert("未入力の項目があります");
        return false;
    }
    
    if(!passwordPattern.test(password)) {
		 alert("英数字8～16文字以内のパスワードを設定してください");
		 return false;
	}
	
	if(passwordConfirm !== password) {
		 alert("入力されたパスワードと確認用パスワードが一致していません。");
		 return false;
	}
	
	
	if (window.confirm('情報の更新後ログアウトします。更新しますか？')) {
        return true;
    } else {
        return false;
    }
}